package net.rainy.superstaff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rainy.superstaff.Superstaff;

public class ModItemGroups {

    public static final ItemGroup SUPER_STICKS_ITEMS = Registry.register(Registries.ITEM_GROUP, Identifier.of(Superstaff.MOD_ID
    ,"super_sticks_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.SUPERSTICK))
                            .displayName(Text.translatable("itemgroup.superstaff.super_sticks_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SUPERSTICK);


                    })



                    .build());




    public static void registerItemGroups(){
        Superstaff.LOGGER.info("so im adding like the custom tab thing for " + Superstaff.MOD_ID);


    }

}
