package net.rainy.superstaff.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.rainy.superstaff.Superstaff;
import net.rainy.superstaff.screen.custom.ArcaneChamberScreenHandler;
public class ModScreenHandlers {
    public static final ScreenHandlerType<ArcaneChamberScreenHandler> ARCANE_CHAMBER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Superstaff.MOD_ID, "arcane_chamber_screen_handler"),
                    new ExtendedScreenHandlerType<>(ArcaneChamberScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        Superstaff.LOGGER.info("Registering Screen Handlers for " + Superstaff.MOD_ID);
    }
}