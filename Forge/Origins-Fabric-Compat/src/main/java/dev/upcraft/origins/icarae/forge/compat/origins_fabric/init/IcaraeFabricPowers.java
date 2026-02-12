package dev.upcraft.origins.icarae.forge.compat.origins_fabric.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.forge.compat.origins_fabric.power.WingsPower;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcaraeFabricPowers {

    @SuppressWarnings("rawtypes") // apoli stupid
    public static final DeferredRegister<PowerFactory> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY.key(), IcaraeOrigin.MODID);

    public static final RegistryObject<PowerFactory<WingsPower>> WINGS_POWER = POWER_FACTORIES.register(WingsPower.POWER_TYPE_ID.getPath(), () -> WingsPower.createFactory().allowCondition());
}
