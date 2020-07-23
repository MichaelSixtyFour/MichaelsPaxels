package dev.advaluti.advtools.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockBreaker {

    public static void breakInRadius(World world, PlayerEntity player, int radius, IBreakValidator breakValidator, IBlockProcessor smelter, boolean damageTool) {
        if(!world.isClient) {
            List<BlockPos> brokenBlocks = findPositions(world, player, radius);
            for(BlockPos pos : brokenBlocks) {
                BlockState state = world.getBlockState(pos);

                if(breakValidator.canBreak(state)) {
                    world.breakBlock(pos, false, player);
                    state.getBlock().onBreak(world, pos, state, player);

                    if(!player.isCreative()) {
                        BlockPos offsetPos = new BlockPos(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5);

                        List<ItemStack> droppedStacks = Block.getDroppedStacks(state, (ServerWorld) world, pos, null, player, player.getMainHandStack());
                        List<ItemStack> processed = new ArrayList<>();

                        droppedStacks.forEach(stack -> processed.add(smelter.process(player.inventory.getMainHandStack(), stack)));

                        dropItems(world, processed, offsetPos);
                        state.onStacksDropped(world, pos, player.getMainHandStack());
                    }

                    if (damageTool) {
                        player.inventory.getMainHandStack().damage(1, player, predicatePlayer -> { });
                    }
                }
            }
        }
    }

    private static void dropItems(World world, List<ItemStack> stacks, BlockPos pos) {
        for(ItemStack stack : stacks) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(itemEntity);
        }
    }

    public static List<BlockPos> findPositions(World world, PlayerEntity playerEntity, int radius) {
        ArrayList<BlockPos> potentialBrokenBlocks = new ArrayList<>();

        Vec3d cameraPos = playerEntity.getCameraPosVec(1);
        Vec3d rotation = playerEntity.getRotationVec(1);
        Vec3d combined = cameraPos.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);

        BlockHitResult blockHitResult = world.rayTrace(new RayTraceContext(cameraPos, combined, RayTraceContext.ShapeType.OUTLINE, RayTraceContext.FluidHandling.NONE, playerEntity));

        if (blockHitResult.getType() == HitResult.Type.BLOCK) {
            Direction.Axis axis = blockHitResult.getSide().getAxis();
            ArrayList<BlockPos> positions = new ArrayList<>();

            for(int x = -radius; x <= radius; x++) {
                for(int y = -radius; y <= radius; y++) {
                    for(int z = -radius; z <= radius; z++) {
                        positions.add(new BlockPos(x, y, z));
                    }
                }
            }

            BlockPos origin = blockHitResult.getBlockPos();

            for(BlockPos pos : positions) {
                if(axis == Direction.Axis.Y) {
                    if(pos.getY() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                }

                else if (axis == Direction.Axis.X) {
                    if(pos.getX() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                }

                else if (axis == Direction.Axis.Z) {
                    if(pos.getZ() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                }
            }
        }

        return potentialBrokenBlocks;
    }

    private BlockBreaker() {

    }
}
