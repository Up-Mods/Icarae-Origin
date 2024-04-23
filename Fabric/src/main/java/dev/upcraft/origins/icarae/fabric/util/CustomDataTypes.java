package dev.upcraft.origins.icarae.fabric.util;

import com.google.gson.JsonParseException;
import com.mojang.serialization.JsonOps;
import dev.upcraft.origins.icarae.util.CodecHelper;
import dev.upcraft.origins.icarae.util.OptionalBool;
import io.github.apace100.calio.data.SerializableDataType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomDataTypes {

    public static final SerializableDataType<ItemStack> STACK_OR_ITEM_NAME = new SerializableDataType<>(ItemStack.class,
            FriendlyByteBuf::writeItem,
            FriendlyByteBuf::readItem,
            jsonElement -> CodecHelper.STACK_OR_ITEM_NAME.decode(JsonOps.INSTANCE, jsonElement).result().orElseThrow(() -> new JsonParseException("Could not parse ItemStack from JSON.")).getFirst()
    );

    public static final SerializableDataType<OptionalBool> OPTIONAL_BOOL = new SerializableDataType<>(OptionalBool.class,
            FriendlyByteBuf::writeEnum,
            buf -> buf.readEnum(OptionalBool.class),
            jsonElement -> {
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
                    return OptionalBool.of(jsonElement.getAsBoolean());
                }
                return OptionalBool.DEFAULT;
            }
    );

    public static final SerializableDataType<OptionalDouble> OPTIONAL_DOUBLE = new SerializableDataType<>(OptionalDouble.class,
            (buf, optionalDouble) -> {
                buf.writeBoolean(optionalDouble.isPresent());
                if (optionalDouble.isPresent()) {
                    buf.writeDouble(optionalDouble.getAsDouble());
                }
            },
            buf -> {
                if (buf.readBoolean()) {
                    return OptionalDouble.of(buf.readDouble());
                }
                return OptionalDouble.empty();
            },
            jsonElement -> {
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                    return OptionalDouble.of(jsonElement.getAsDouble());
                }
                return OptionalDouble.empty();
            }
    );

    public static final SerializableDataType<OptionalInt> OPTIONAL_INT = new SerializableDataType<>(OptionalInt.class,
            (buf, optionalInt) -> {
                buf.writeBoolean(optionalInt.isPresent());
                if (optionalInt.isPresent()) {
                    buf.writeInt(optionalInt.getAsInt());
                }
            },
            buf -> {
                if (buf.readBoolean()) {
                    return OptionalInt.of(buf.readInt());
                }
                return OptionalInt.empty();
            },
            jsonElement -> {
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                    return OptionalInt.of(jsonElement.getAsInt());
                }
                return OptionalInt.empty();
            }
    );
}
