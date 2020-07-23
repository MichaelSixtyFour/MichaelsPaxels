package dev.advaluti.advpaxels;

import dev.advaluti.advpaxels.items.BasePaxel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
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
    public final ItemGroup ADVPAXELS_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "advpaxels"), () -> new ItemStack(this.WOODEN_PAXEL));

    // Register Paxels
    public final BasePaxel WOODEN_PAXEL = new BasePaxel((float) 3.5, 1, ToolMaterials.WOOD, new Item.Settings().group(ADVPAXELS_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_paxel"), WOODEN_PAXEL);
    }
}