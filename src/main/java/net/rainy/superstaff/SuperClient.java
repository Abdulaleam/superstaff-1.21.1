package net.rainy.superstaff;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.rainy.superstaff.screen.ModScreenHandlers;
import net.rainy.superstaff.screen.custom.ArcaneChamberScreen;

public class SuperClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ARCANE_CHAMBER_SCREEN_HANDLER, ArcaneChamberScreen::new);
    }
}