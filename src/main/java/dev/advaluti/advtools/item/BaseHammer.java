package dev.advaluti.advtools.item;

import dev.advaluti.advtools.util.IAreaTool;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BaseHammer extends PickaxeItem implements IAreaTool {
    private int breakRadius = 1;

    public BaseHammer(float damage, float speed, ToolMaterial material,Settings settings, int breakRadius) {
        super(material, (int) damage, speed, settings);
        this.breakRadius = breakRadius;
    }

    public BaseHammer(float damage, float speed, ToolMaterial material, Settings settings) {
        super(material, (int) damage, speed, settings);
    }

    @Override
    public int getRadius(ItemStack stack) {
        return breakRadius;
    }

    @Override
    public boolean playBreakEffects() {
        return false;
    }
}
