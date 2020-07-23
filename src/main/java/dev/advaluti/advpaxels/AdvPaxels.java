package dev.advaluti.advpaxels;

import dev.advaluti.advpaxels.item.BaseItem;
import dev.advaluti.advpaxels.item.BasePaxel;
import dev.advaluti.advpaxels.material.BaseToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdvPaxels implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "advpaxels";
    public static final String MOD_NAME = "AdvPaxels";

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    // Item Group
    public final ItemGroup ADVPAXELS_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(this.WOODEN_PAXEL));

    // Register Misc.
    public final BaseItem STONE_ROD = new BaseItem(new Item.Settings().group(ADVPAXELS_GROUP));

    // Register Paxels
    public final BasePaxel WOODEN_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.WOOD, new Item.Settings().group(ADVPAXELS_GROUP));
    public final BasePaxel STONE_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.STONE, new Item.Settings().group(ADVPAXELS_GROUP));
    public final BasePaxel IRON_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.IRON, new Item.Settings().group(ADVPAXELS_GROUP));
    public final BasePaxel GOLD_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.GOLD, new Item.Settings().group(ADVPAXELS_GROUP));
    public final BasePaxel DIAMOND_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.DIAMOND, new Item.Settings().group(ADVPAXELS_GROUP));
    public final BasePaxel NETHERITE_PAXEL = new BasePaxel(3.5F, -2.8F, BaseToolMaterial.NETHERITE, new Item.Settings().group(ADVPAXELS_GROUP).fireproof());

    // Register Modded Paxels

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_rod"), STONE_ROD);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_paxel"), WOODEN_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_paxel"), STONE_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_paxel"), IRON_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_paxel"), GOLD_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_paxel"), DIAMOND_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_paxel"), NETHERITE_PAXEL);
    }
}