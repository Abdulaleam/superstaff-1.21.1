package net.rainy.superstaff;

import net.fabricmc.api.ModInitializer;

import net.rainy.superstaff.block.ModBlocks;
import net.rainy.superstaff.entity.ModBlockEntities;
import net.rainy.superstaff.item.ModItemGroups;
import net.rainy.superstaff.item.ModItems;
import net.rainy.superstaff.recipe.ModRecipes;
import net.rainy.superstaff.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Superstaff implements ModInitializer {
	public static final String MOD_ID = "superstaff";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
	}

}