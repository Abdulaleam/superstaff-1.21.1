package net.rainy.superstaff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.superstaff.Superstaff;
import net.rainy.superstaff.block.custom.ArcaneChamberBlock;


public class ModBlocks {
    public static final Block ARCANE_CHAMBER =
            registerBlock("arcane_chamber", new ArcaneChamberBlock(AbstractBlock.Settings.create()));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Superstaff.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Superstaff.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Superstaff.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Superstaff.LOGGER.info("Registering Mod Block for the 10th time for " + Superstaff.MOD_ID);

    }}
