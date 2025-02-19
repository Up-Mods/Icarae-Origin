package dev.upcraft.origins.icarae.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;

public class CodecHelper {

    public static final Codec<ItemStack> STACK_OR_ITEM_NAME = Codec.withAlternative(ItemStack.CODEC, BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem));
}
