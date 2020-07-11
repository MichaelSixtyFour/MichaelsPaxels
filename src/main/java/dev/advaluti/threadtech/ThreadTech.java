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

public class ThreadTech implements ModInitializer {

    public static String MODID = "threadtech";
    
    //COPPER
    public static final BlockOres ORE_COPPER = new BlockOres(Block.Settings.of(Material.STONE));

    @Override
    public void onInitialize() {

        //COPPER
        Registry.register(Registry.BLOCK, new Identifier(MODID, "orecopper"), ORE_COPPER);
        Registry.register(Registry.ITEM, new Identifier(MODID, "orecopper"), new BlockItem(ORE_COPPER, new Item.Settings().group(ItemGroup.MISC)));
    }
}
