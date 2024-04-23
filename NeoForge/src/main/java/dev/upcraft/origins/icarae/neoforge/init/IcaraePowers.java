package dev.upcraft.origins.icarae.neoforge.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.neoforge.power.WingsPower;
import dev.upcraft.origins.icarae.neoforge.power.WingsPowerFactory;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcaraePowers {

    public static final DeferredRegister<PowerFactory<?>> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY_KEY, IcaraeOrigin.MODID);

    public static final RegistryObject<PowerFactory<WingsPower>> WINGS_POWER = POWER_FACTORIES.register("wings", WingsPowerFactory::new);
}
