package net.rainy.superstaff.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rainy.superstaff.Superstaff;

public class ModRecipes {
    public static final RecipeSerializer<ArcaneChamberRecipe>ARCANE_CHAMBER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Superstaff.MOD_ID, "arcane_chamber"),
            new ArcaneChamberRecipe.Serializer());
    public static final RecipeType<ArcaneChamberRecipe> ARCANE_CHAMBER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Superstaff.MOD_ID, "arcane_chamber"), new RecipeType<ArcaneChamberRecipe>() {
                @Override
                public String toString() {
                    return "arcane_chamber";
                }
            });

    public static void registerRecipes() {
        Superstaff.LOGGER.info("Registering Custom Recipes like the tiers and staffs for " + Superstaff.MOD_ID);
    }
}