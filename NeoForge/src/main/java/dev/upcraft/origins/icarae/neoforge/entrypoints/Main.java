package dev.upcraft.origins.icarae.neoforge.entrypoints;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.neoforge.init.IcaraePowers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IcaraeOrigin.MODID)
public class Main {

    public Main() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        IcaraePowers.POWER_FACTORIES.register(bus);
    }
}
