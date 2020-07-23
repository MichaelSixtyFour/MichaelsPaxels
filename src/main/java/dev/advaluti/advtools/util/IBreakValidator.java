package dev.advaluti.advtools.util;

import net.minecraft.block.BlockState;

public interface IBreakValidator {
    boolean canBreak(BlockState state);
}
