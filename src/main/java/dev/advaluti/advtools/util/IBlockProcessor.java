package dev.advaluti.advtools.util;

import net.minecraft.item.ItemStack;

public interface IBlockProcessor {
    ItemStack process(ItemStack tool, ItemStack input);
}
