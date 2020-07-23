package dev.advaluti.advpaxels.items;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

import java.util.HashSet;

public class BasePaxel extends MiningToolItem {

    public BasePaxel(float damage, float speed, ToolMaterial material, Settings settings) {
        super(damage, speed, material, new HashSet<>(), settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return true;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return miningSpeed;
    }
}
