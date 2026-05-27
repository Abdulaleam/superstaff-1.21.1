package net.rainy.superstaff;

import net.fabricmc.api.ModInitializer;

import net.rainy.superstaff.item.ModItemGroups;
import net.rainy.superstaff.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Superstaff implements ModInitializer {
	public static final String MOD_ID = "superstaff";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}