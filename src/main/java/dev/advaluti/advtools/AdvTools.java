package dev.advaluti.advtools;

import dev.advaluti.advtools.item.BaseHammer;
import dev.advaluti.advtools.item.BasePaxel;
import dev.advaluti.advtools.material.BaseToolMaterial;
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

public class AdvTools implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "advtools";
    public static final String MOD_NAME = "AdvPaxels";

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    // Item Group
    public final ItemGroup ADVTOOLS_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "advtools"), () -> new ItemStack(this.WOODEN_PAXEL));

    // Register Paxels
    public final BasePaxel WOODEN_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.WOOD, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BasePaxel STONE_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.STONE, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BasePaxel IRON_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.IRON, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BasePaxel GOLD_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.GOLD, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BasePaxel DIAMOND_PAXEL = new BasePaxel( 3.5F,  -2.8F, BaseToolMaterial.DIAMOND, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BasePaxel NETHERITE_PAXEL = new BasePaxel(3.5F, -2.8F, BaseToolMaterial.NETHERITE, new Item.Settings().group(ADVTOOLS_GROUP).fireproof());

    // Register Hammers
    public final BaseHammer WOODEN_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.WOOD, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BaseHammer STONE_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.STONE, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BaseHammer IRON_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.IRON, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BaseHammer GOLD_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.GOLD, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BaseHammer DIAMOND_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.DIAMOND, new Item.Settings().group(ADVTOOLS_GROUP));
    public final BaseHammer NETHERITE_HAMMER = new BaseHammer(3.5F, -2.8F, BaseToolMaterial.NETHERITE, new Item.Settings().group(ADVTOOLS_GROUP).fireproof());

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_paxel"), WOODEN_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_paxel"), STONE_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_paxel"), IRON_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_paxel"), GOLD_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_paxel"), DIAMOND_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_paxel"), NETHERITE_PAXEL);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_hammer"), WOODEN_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_hammer"), STONE_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_hammer"), IRON_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_hammer"), GOLD_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_hammer"), DIAMOND_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_hammer"), NETHERITE_HAMMER);
    }
}