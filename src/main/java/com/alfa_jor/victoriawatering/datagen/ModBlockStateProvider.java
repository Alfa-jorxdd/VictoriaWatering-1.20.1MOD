package com.alfa_jor.victoriawatering.datagen;

import com.alfa_jor.victoriawatering.VictoriaWatering;
import com.alfa_jor.victoriawatering.block.ModBlocks;
import com.alfa_jor.victoriawatering.block.custom.CilantroCropblock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VictoriaWatering.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SUNFLOWER_BLOCK);

        createCropBlockStates(ModBlocks.CILANTRO_CROP.get(), CilantroCropblock.AGE, "cilantro_stage", "cilantro_stage");
    }

    private void createCropBlockStates(Block pBlock, IntegerProperty pCropAgeProperty, String pModelName, String pTextureName){
        getVariantBuilder(pBlock).forAllStates(state ->
                generateCropModel(state, pCropAgeProperty, pModelName, pTextureName));
    }

    private ConfiguredModel[] generateCropModel(BlockState state, IntegerProperty pCropAgeProperty, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(pCropAgeProperty),
                ResourceLocation.tryBuild(VictoriaWatering.MOD_ID, "block/" + textureName + state.getValue(pCropAgeProperty))).renderType("cutout"));

        return models;
    }

    //"Este bloque es un cubo simple y su item usa el mismo modelo"
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
