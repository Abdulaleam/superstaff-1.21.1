package net.rainy.superstaff.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.rainy.superstaff.Superstaff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.superstaff.item.custom.*;

public class ModItems {
    public static final Item SUPERSTICK = registerItem("superstick", new Item(new Item.Settings()));
    public static final Item TIER1 = registerItem("tierone", new TierOne(new Item.Settings()));
    public static final Item TIER2 = registerItem("tiertwo", new TierTwo(new Item.Settings()));
    public static final Item TIER3 = registerItem("tierthree", new TierThree(new Item.Settings()));
    public static final Item TIER4 = registerItem("tierfour", new TierFour(new Item.Settings()));
    public static final Item TIER5 = registerItem("tierfive", new TierFive(new Item.Settings()));
    public static final Item TIER6 = registerItem("tiersix", new TierSix(new Item.Settings()));
    public static final Item TIER7 = registerItem("tierseven", new TierSeven(new Item.Settings()));
    public static final Item TIER8 = registerItem("tiereight", new TierEight(new Item.Settings()));
    public static final Item TIER9 = registerItem("tiernine", new TierNine(new Item.Settings()));
    public static final Item TIER10 = registerItem("tierten", new TierTen(new Item.Settings()));
    public static final Item MAGIC_GEM = registerItem("magic_gem", new Item(new Item.Settings()));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Superstaff.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Superstaff.LOGGER.info("registeringgg sticks for " + Superstaff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(SUPERSTICK);
            entries.add(TIER1);
            entries.add(TIER2);
            entries.add(TIER3);
            entries.add(TIER4);
            entries.add(TIER5);
            entries.add(TIER8);
            entries.add(TIER9);
            entries.add(TIER10);
            entries.add(MAGIC_GEM);

        });
    }
}