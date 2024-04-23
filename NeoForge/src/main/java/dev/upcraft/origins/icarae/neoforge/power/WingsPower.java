package dev.upcraft.origins.icarae.neoforge.power;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.cammiescorner.icarus.api.IcarusPlayerValues;
import dev.cammiescorner.icarus.util.ServerPlayerFallbackValues;
import dev.upcraft.origins.icarae.util.CodecHelper;
import dev.upcraft.origins.icarae.util.OptionalBool;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public final class WingsPower implements IcarusPlayerValues, IDynamicFeatureConfiguration {

    private IcarusPlayerValues fallback = new ServerPlayerFallbackValues();

    private final ItemStack cosmeticWingsType;
    private final OptionalBool applyArmorSlowdown;
    private final OptionalDouble maxSlowedMultiplierValue;
    private final OptionalDouble wingsSpeedValue;
    private final OptionalDouble exhaustionAmountValue;
    private final OptionalInt maxHeighAboveWorld;

    public WingsPower(ItemStack cosmeticWingsType, OptionalBool applyArmorSlowdown,
                      OptionalDouble maxSlowedMultiplierValue,
                      OptionalDouble wingsSpeedValue, OptionalDouble exhaustionAmountValue,
                      OptionalInt maxHeighAboveWorld) {
        this.cosmeticWingsType = cosmeticWingsType;
        this.applyArmorSlowdown = applyArmorSlowdown;
        this.maxSlowedMultiplierValue = maxSlowedMultiplierValue;
        this.wingsSpeedValue = wingsSpeedValue;
        this.exhaustionAmountValue = exhaustionAmountValue;
        this.maxHeighAboveWorld = maxHeighAboveWorld;
    }

    public void updateFallback(IcarusPlayerValues fallback) {
        this.fallback = fallback;
    }

    @Override
    public float wingsSpeed() {
        return (float) wingsSpeedValue.orElseGet(fallback::wingsSpeed);
    }

    @Override
    public float maxSlowedMultiplier() {
        return (float) maxSlowedMultiplierValue.orElseGet(fallback::maxSlowedMultiplier);
    }

    @Override
    public boolean armorSlows() {
        return applyArmorSlowdown.orElseGet(fallback::armorSlows);
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
        return (float) exhaustionAmountValue.orElseGet(fallback::exhaustionAmount);
    }

    @Override
    public int maxHeightAboveWorld() {
        return maxHeighAboveWorld.orElseGet(fallback::maxHeightAboveWorld);
    }

    @Override
    public boolean maxHeightEnabled() {
        return maxHeighAboveWorld.isPresent() || fallback.maxHeightEnabled();
    }

    public ItemStack cosmeticWingsType() {
        return cosmeticWingsType;
    }

    public OptionalBool applyArmorSlowdown() {
        return applyArmorSlowdown;
    }

    public OptionalDouble maxSlowedMultiplierValue() {
        return maxSlowedMultiplierValue;
    }

    public OptionalDouble wingsSpeedValue() {
        return wingsSpeedValue;
    }

    public OptionalDouble exhaustionAmountValue() {
        return exhaustionAmountValue;
    }

    public OptionalInt maxHeighAboveWorld() {
        return maxHeighAboveWorld;
    }

    public static final Codec<WingsPower> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.STACK_OR_ITEM_NAME.fieldOf("wings_type").forGetter(WingsPower::cosmeticWingsType),
            OptionalBool.codecFieldOf("armor_slows").forGetter(WingsPower::applyArmorSlowdown),
            ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("max_slowed_multiplier").xmap(opt -> opt.map(OptionalDouble::of).orElseGet(OptionalDouble::empty), optionalDouble -> optionalDouble.isEmpty() ? Optional.empty() : Optional.of((float) optionalDouble.getAsDouble())).forGetter(WingsPower::maxSlowedMultiplierValue),
            ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("wings_speed").xmap(opt -> opt.map(OptionalDouble::of).orElseGet(OptionalDouble::empty), optionalDouble -> optionalDouble.isEmpty() ? Optional.empty() : Optional.of((float) optionalDouble.getAsDouble())).forGetter(WingsPower::wingsSpeedValue),
            Codec.DOUBLE.optionalFieldOf("exhaustion_amount").xmap(opt -> opt.map(OptionalDouble::of).orElseGet(OptionalDouble::empty), optionalDouble -> optionalDouble.isEmpty() ? Optional.empty() : Optional.of(optionalDouble.getAsDouble())).forGetter(WingsPower::exhaustionAmountValue),
            ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("max_height_above_world").xmap(opt -> opt.map(OptionalInt::of).orElseGet(OptionalInt::empty), optionalInt -> optionalInt.isEmpty() ? Optional.empty() : Optional.of(optionalInt.getAsInt())).forGetter(WingsPower::maxHeighAboveWorld)
    ).apply(instance, WingsPower::new));

}
