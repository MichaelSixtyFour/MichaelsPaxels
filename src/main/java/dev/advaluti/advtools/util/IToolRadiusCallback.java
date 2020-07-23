package dev.advaluti.advtools.util;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.item.ItemStack;

public interface IToolRadiusCallback {
    Event<IToolRadiusCallback> EVENT = EventFactory.createArrayBacked(IToolRadiusCallback.class,
            listeners -> (tool, currentRadius) -> {
                for (IToolRadiusCallback callback : listeners) {
                    currentRadius = callback.getRadius(tool, currentRadius);
                }

                return currentRadius;
            });

    int getRadius(ItemStack tool, int currentRadius);
}
