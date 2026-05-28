package net.rainy.superstaff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.rainy.superstaff.block.ModBlocks;
import net.rainy.superstaff.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARCANE_CHAMBER);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TIER1, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER2, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER3, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER4, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER5, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER6, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER7, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER8, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER9, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIER10, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_GEM, Models.GENERATED);


    }
}
