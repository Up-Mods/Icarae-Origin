package dev.upcraft.origins.icarae.quilt.init;

import dev.upcraft.origins.icarae.quilt.power.WingsPower;
import io.github.apace100.apoli.power.factory.PowerFactory;

public class IcaraePowers {

    public static final PowerFactory<WingsPower> WINGS_POWER = WingsPower.createFactory().allowCondition();
}
