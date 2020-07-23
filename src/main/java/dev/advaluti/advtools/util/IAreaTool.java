package dev.advaluti.advtools.util;

import net.minecraft.block.InfestedBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IAreaTool {
    int getRadius(ItemStack stack);

    boolean playBreakEffects();

    default IBlockProcessor getProcessor(World world, PlayerEntity player, BlockPos pos, ItemStack heldItem) {
        return(tool, input) -> input;
    }

    default boolean tryBreak(World world, BlockPos pos, PlayerEntity player, int breakRadius, IBlockProcessor processor) {
        if (player.isSneaking()) {
            return true;
        }

        float originHardness = world.getBlockState(pos).getHardness(world, pos);
        ItemStack mainHandStack = player.getMainHandStack();

        if (mainHandStack.isEffectiveOn(world.getBlockState(pos))) {
            int radius = IToolRadiusCallback.EVENT.invoker().getRadius(mainHandStack, breakRadius);

            BlockBreaker.breakInRadius(world, player, radius, (breakState) -> {
                double hardness = breakState.getHardness(null, null);

                boolean isEffective = mainHandStack.isEffectiveOn(breakState) || breakState.getBlock() instanceof InfestedBlock;

                boolean verifyHardness = hardness < originHardness * 5 && (breakState.getBlock() instanceof InfestedBlock || hardness > 0);

                return isEffective && verifyHardness;
            }, processor, true);
        }

        return true;
    }
}
