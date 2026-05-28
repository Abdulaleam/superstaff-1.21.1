package net.rainy.superstaff.entity;

import net.rainy.superstaff.Superstaff;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.superstaff.block.ModBlocks;


public class ModBlockEntities {

    public static final BlockEntityType<ArcaneChamberBlockEntity> ARCANE_CHAMBER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Superstaff.MOD_ID, "arcane_chamber_be"),
                    BlockEntityType.Builder.create(ArcaneChamberBlockEntity::new, ModBlocks.ARCANE_CHAMBER).build(null));


    public static void registerBlockEntities() {
        Superstaff.LOGGER.info("Registering Block Entities for " + Superstaff.MOD_ID);
    }
}