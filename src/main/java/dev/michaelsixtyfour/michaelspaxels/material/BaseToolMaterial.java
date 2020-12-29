package dev.michaelsixtyfour.michaelspaxels.material;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

import static dev.michaelsixtyfour.michaelspaxels.item.BasePaxel.durabilityModifier;

public enum BaseToolMaterial implements ToolMaterial {
    WOOD(0, 59 * durabilityModifier, 2.0F, 0.0F, 15, () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE(1, 131 * durabilityModifier, 4.0F, 1.0F, 5, () -> Ingredient.ofItems(Blocks.COBBLESTONE)),
    IRON(2, 230 * durabilityModifier, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    GOLD(0, 32 * durabilityModifier, 12.0F, 0.0F, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND(3, 1561 * durabilityModifier, 8.0F, 3.0F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE(3, 2031 * durabilityModifier, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(Items.DIAMOND));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    BaseToolMaterial(int miningLevel, double itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = (int) itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}