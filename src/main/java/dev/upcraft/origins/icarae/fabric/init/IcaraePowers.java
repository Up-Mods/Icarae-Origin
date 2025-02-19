package dev.upcraft.origins.icarae.fabric.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.fabric.power.WingsPower;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import io.github.apace100.apoli.power.PowerConfiguration;
import io.github.apace100.apoli.power.type.PowerType;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.registry.ApoliRegistryKeys;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class IcaraePowers {

    static {
        // TODO remove once fixed in sparkweave
        // this exists so apoli definitely registers its registries before we try to retrieve them.
        ApoliRegistries.POWER_TYPE.size();
    }

    // FIXME dirty hack because origins used the wrong type for their registry
    // (and instead of fixing it just did a rawcast themselves........ <https://github.com/apace100/apoli/blob/c885df0866a8034e5f2386ae0e1da38e64357eb7/src/main/java/io/github/apace100/apoli/power/type/PowerTypes.java#L143-L151>)
    public static final RegistryHandler<PowerConfiguration<? extends PowerType>> POWER_TYPES = RegistryHandler.create((ResourceKey<Registry<PowerConfiguration<? extends PowerType>>>)(Object) ApoliRegistryKeys.POWER_TYPE, IcaraeOrigin.MODID);

    public static final RegistrySupplier<PowerConfiguration<WingsPower>> WINGS = POWER_TYPES.register("wings", () -> PowerConfiguration.of(WingsPower.POWER_TYPE_ID, WingsPower.DATA_FACTORY));

}
