package dev.upcraft.origins.icarae.fabric.power;

import dev.cammiescorner.icarus.api.IcarusPlayerValues;
import dev.cammiescorner.icarus.util.ServerPlayerFallbackValues;
import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.fabric.init.IcaraePowers;
import dev.upcraft.origins.icarae.fabric.util.CustomDataTypes;
import dev.upcraft.origins.icarae.util.OptionalBool;
import io.github.apace100.apoli.data.TypedDataObjectFactory;
import io.github.apace100.apoli.power.PowerConfiguration;
import io.github.apace100.apoli.power.type.PowerType;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalDouble;
import java.util.OptionalInt;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class WingsPower extends PowerType implements IcarusPlayerValues {

    public static final ResourceLocation POWER_TYPE_ID = IcaraeOrigin.id("wings");
    public static final TypedDataObjectFactory<WingsPower> DATA_FACTORY = PowerType.createConditionedDataFactory(
            new SerializableData()
                    .add("wings_type", CustomDataTypes.STACK_OR_ITEM_NAME)
                    .add("armor_slows", CustomDataTypes.OPTIONAL_BOOL, OptionalBool.DEFAULT)
                    .add("max_slowed_multiplier", CustomDataTypes.OPTIONAL_DOUBLE, OptionalDouble.empty())
                    .add("wings_speed", CustomDataTypes.OPTIONAL_DOUBLE, OptionalDouble.empty())
                    .add("exhaustion_amount", CustomDataTypes.OPTIONAL_DOUBLE, OptionalDouble.empty())
                    .add("max_height_above_world", CustomDataTypes.OPTIONAL_INT, OptionalInt.empty()),
            (data, entityCondition) -> {
                ItemStack wingsType = data.get("wings_type");
                OptionalBool armorSlows = data.get("armor_slows");
                OptionalDouble maxSlowedMultiplier = data.get("max_slowed_multiplier");
                OptionalDouble wingsSpeed = data.get("wings_speed");
                OptionalDouble exhaustionAmount = data.get("exhaustion_amount");
                OptionalInt maxHeightAboveWorld = data.get("max_height_above_world");

                return new WingsPower(wingsType, armorSlows, maxSlowedMultiplier, wingsSpeed, exhaustionAmount, maxHeightAboveWorld);
            },
            (wingsPower, serializableData) -> serializableData.instance()
                    .set("wings_type", wingsPower.wingsType)
                    .set("armor_slows", wingsPower.armorSlows)
                    .set("max_slowed_multiplier", wingsPower.maxSlowedMultiplier)
                    .set("wings_speed", wingsPower.wingsSpeed)
                    .set("exhaustion_amount", wingsPower.exhaustionAmount)
                    .set("max_height_above_world", wingsPower.maxHeightAboveWorld)
    );

    private final ItemStack wingsType;
    private final OptionalBool armorSlows;
    private final OptionalDouble maxSlowedMultiplier;
    private final OptionalDouble wingsSpeed;
    private final OptionalDouble exhaustionAmount;
    private final OptionalInt maxHeightAboveWorld;

    private IcarusPlayerValues fallback = new ServerPlayerFallbackValues();

    public WingsPower(ItemStack wingsType, OptionalBool armorSlows, OptionalDouble maxSlowedMultiplier, OptionalDouble wingsSpeed, OptionalDouble exhaustionAmount, OptionalInt maxHeightAboveWorld) {
        this.wingsType = wingsType;
        this.armorSlows = armorSlows;
        this.maxSlowedMultiplier = maxSlowedMultiplier;
        this.wingsSpeed = wingsSpeed;
        this.exhaustionAmount = exhaustionAmount;
        this.maxHeightAboveWorld = maxHeightAboveWorld;
    }

    public ItemStack getWingsType() {
        return wingsType;
    }

    public void updateFallback(IcarusPlayerValues fallback) {
        this.fallback = fallback;
    }

    @Override
    public float wingsSpeed() {
        return (float) wingsSpeed.orElseGet(fallback::wingsSpeed);
    }

    @Override
    public float maxSlowedMultiplier() {
        return (float) maxSlowedMultiplier.orElseGet(fallback::maxSlowedMultiplier);
    }

    @Override
    public boolean armorSlows() {
        return armorSlows.orElseGet(fallback::armorSlows);
    }

    @Override
    public boolean canLoopDeLoop() {
        return fallback.canLoopDeLoop();
    }

    @Override
    public boolean canSlowFall() {
        return fallback.canSlowFall();
    }

    @Override
    public float exhaustionAmount() {
        return (float) exhaustionAmount.orElseGet(fallback::exhaustionAmount);
    }

    @Override
    public int maxHeightAboveWorld() {
        return maxHeightAboveWorld.orElseGet(fallback::maxHeightAboveWorld);
    }

    @Override
    public boolean maxHeightEnabled() {
        return maxHeightAboveWorld.isPresent() || fallback.maxHeightEnabled();
    }

    @Override
    public @NotNull PowerConfiguration<?> getConfig() {
        return IcaraePowers.WINGS.get();
    }
}
