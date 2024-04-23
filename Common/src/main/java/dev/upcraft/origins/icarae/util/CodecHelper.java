package dev.upcraft.origins.icarae.util;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;

import java.util.function.UnaryOperator;

public class CodecHelper {

    public static final Codec<ItemStack> STACK_OR_ITEM_NAME = Codec.either(ItemStack.CODEC, BuiltInRegistries.ITEM.byNameCodec()).xmap(either -> either.map(UnaryOperator.identity(), ItemStack::new), Either::left);
}
