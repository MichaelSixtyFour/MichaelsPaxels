package dev.advaluti.threadtech;

import dev.advaluti.threadtech.blocks.BlockOres;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadTech implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "threadtech";
    public static final String MOD_NAME = "ThreadTech";

    //BLOCKS
    public static final BlockOres ORE_COPPER = new BlockOres(Block.Settings.of(Material.STONE));
    public static final BlockOres ORE_TIN = new BlockOres(Block.Settings.of(Material.STONE));

    //ITEMS
    public static final Item MACH_GLASSPANEL = new Item(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        //COMPONENTS
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "machglasspanel"), MACH_GLASSPANEL);


        //COPPER
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "orecopper"), ORE_COPPER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orecopper"), new BlockItem(ORE_COPPER, new Item.Settings().group(ItemGroup.MISC)));

        //TIN
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oretin"), ORE_TIN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oretin"), new BlockItem(ORE_TIN, new Item.Settings().group(ItemGroup.MISC)));
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}