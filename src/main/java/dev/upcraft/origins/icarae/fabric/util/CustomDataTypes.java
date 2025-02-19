package dev.upcraft.origins.icarae.fabric.util;

import dev.upcraft.origins.icarae.util.CodecHelper;
import dev.upcraft.origins.icarae.util.OptionalBool;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomDataTypes {

    public static final SerializableDataType<ItemStack> STACK_OR_ITEM_NAME = SerializableDataType.of(CodecHelper.STACK_OR_ITEM_NAME, ItemStack.STREAM_CODEC);

    public static final SerializableDataType<OptionalBool> OPTIONAL_BOOL = SerializableDataTypes.BOOLEAN.optional().xmap(opt -> opt.map(OptionalBool::of).orElse(OptionalBool.DEFAULT), OptionalBool::asOptional);

    public static final SerializableDataType<OptionalDouble> OPTIONAL_DOUBLE = SerializableDataTypes.DOUBLE.optional().xmap(opt -> opt.map(OptionalDouble::of).orElse(OptionalDouble.empty()), optionalDouble -> optionalDouble.isEmpty() ? Optional.empty() : Optional.of(optionalDouble.getAsDouble()));

    public static final SerializableDataType<OptionalInt> OPTIONAL_INT = SerializableDataTypes.INT.optional().xmap(opt -> opt.map(OptionalInt::of).orElse(OptionalInt.empty()), optionalInt -> optionalInt.isEmpty() ? Optional.empty() : Optional.of(optionalInt.getAsInt()));
}
