package dev.upcraft.origins.icarae.quilt.init;

import dev.upcraft.origins.icarae.quilt.power.WingsPower;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.core.Registry;

public class IcaraePowers {

    public static final PowerFactory<WingsPower> WINGS_POWER = WingsPower.createFactory().allowCondition();

    public static void register() {
        Registry.register(ApoliRegistries.POWER_FACTORY, WingsPower.POWER_TYPE_ID, IcaraePowers.WINGS_POWER);
    }
}
