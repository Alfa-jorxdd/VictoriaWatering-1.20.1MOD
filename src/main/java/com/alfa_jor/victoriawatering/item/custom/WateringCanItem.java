package com.alfa_jor.victoriawatering.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class WateringCanItem extends Item {

    public WateringCanItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();

        int water = getWater(stack);

        if (water <= 0) {
            return InteractionResult.PASS;
        }
        if (applyBonemeal(stack, level, pos, player)) {
            if (!level.isClientSide) {
                setWater(stack, water - 200);
                level.levelEvent(1505, pos, 0);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //Extrae el item del jugador
        ItemStack stack = player.getItemInHand(hand);
        //Hace un reporte de la cara del bloque en el que colisionó al hacer alticlick (ClipContext.Fluid.SOURCE_ONLY se asegura que solo tome agua de bloques de agua fuentes)
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        }
        //Extrae la posición del bloque del informe
        BlockPos pos = hitResult.getBlockPos();
        //Extrae el estado del bloque del nivel con ayuda del pos
        BlockState state = level.getBlockState(pos);

        if (!state.getFluidState().isSource() || !state.getFluidState().is(Fluids.WATER)) {
            return InteractionResultHolder.pass(stack);
       }

        if (state.getBlock() instanceof BucketPickup pickup){
            if (!level.isClientSide){
                pickup.getPickupSound(state).ifPresent(
                        soundWater -> level.playSound(
                                null, pos, soundWater, SoundSource.BLOCKS, 1.0f, 1.0f));

                pickup.pickupBlock(level, pos, state);

                setWater(stack, 1000);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    public static boolean applyBonemeal(
            ItemStack pStack, Level pLevel, BlockPos pPos, net.minecraft.world.entity.player.Player player) {
        BlockState blockstate = pLevel.getBlockState(pPos);

        if (blockstate.getBlock() instanceof BonemealableBlock) {
            BonemealableBlock bonemealableblock = (BonemealableBlock) blockstate.getBlock();
            if (bonemealableblock.isValidBonemealTarget(pLevel, pPos, blockstate, pLevel.isClientSide)) {
                if (pLevel instanceof ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(pLevel, pLevel.random, pPos, blockstate)) {
                        bonemealableblock.performBonemeal((ServerLevel) pLevel, pLevel.random, pPos, blockstate);
                    }
                }

                return true;
            }
        }

        return false;
    }

    public static int getWater(ItemStack stack){
        return stack.getOrCreateTag().getInt("water");
    }

    public static void setWater(ItemStack stack, int amount){
        stack.getOrCreateTag().putInt("water", amount);
    }
}
