package dev.upcraft.origins.icarae.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import java.util.Optional;
import java.util.function.BooleanSupplier;

public enum OptionalBool {

    TRUE,
    FALSE,
    DEFAULT;

    public static OptionalBool of(Boolean value) {
        return value == null ? DEFAULT : value ? TRUE : FALSE;
    }

    public boolean isTrue() {
        return this == TRUE;
    }

    public boolean orElse(boolean defaultValue) {
        return this == TRUE || (this == DEFAULT && defaultValue);
    }

    public boolean orElseGet(BooleanSupplier defaultValue) {
        return this == TRUE || (this == DEFAULT && defaultValue.getAsBoolean());
    }

    public Optional<Boolean> asOptional() {
        return this == DEFAULT ? Optional.empty() : Optional.of(isTrue());
    }

    public static MapCodec<OptionalBool> codecFieldOf(String fieldName) {
        return Codec.BOOL.optionalFieldOf(fieldName).xmap(opt -> opt.map(aBoolean -> aBoolean ? TRUE : FALSE).orElse(DEFAULT), OptionalBool::asOptional);
    }
}
