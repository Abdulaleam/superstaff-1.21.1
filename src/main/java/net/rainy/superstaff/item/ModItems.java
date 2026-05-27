package net.rainy.superstaff.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.rainy.superstaff.Superstaff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUPERSTICK = registerItem("superstick", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Superstaff.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Superstaff.LOGGER.info("registeringgg sticks for " + Superstaff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(SUPERSTICK);
        });
    }
}