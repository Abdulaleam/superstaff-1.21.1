package net.rainy.superstaff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.rainy.superstaff.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_GEM)
                .pattern("RRR")
                .pattern("RFR")
                .pattern("RRR")
                .input('R', Items.GOLD_INGOT)
                .input('F', Items.DIAMOND)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
        .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIER1)
                .pattern("F")
                .pattern("R")
                .pattern("R")
                .input('R', Items.STICK)
                .input('F', ModItems.MAGIC_GEM)
                .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                .offerTo(exporter);



    }
}
