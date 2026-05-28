package net.rainy.superstaff.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TierSeven extends Item {
// alr so what i wanna do is make this the ice staff like throwing snow ball makes it change blocks to ice
    public TierSeven(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {

            Vec3d look = user.getRotationVec(1.0F);
            SnowballEntity snowball = new SnowballEntity(world, user) {

                @Override
                protected void onBlockHit(BlockHitResult hit) {
                    super.onBlockHit(hit);

                    BlockPos center = hit.getBlockPos();

                    for (int x = -9; x <= 10; x++) {
                        for (int y = -3; y <= 3; y++) {
                            for (int z = -10; z <= 12; z++) {
                                // perfect random radiuis xD
                                BlockPos pos = center.add(x, y, z);
                                if (!world.getBlockState(pos).isAir()) {
                                    world.setBlockState(pos, Blocks.LAVA.getDefaultState());
                                }}}}

                    world.playSound(null, center, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS);
                    // PERFECTO

                }

            };
            snowball.setOwner(user);
            snowball.setVelocity(look.x, look.y, look.z, 1.5F, 0.0F);
            world.spawnEntity(snowball);
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS);
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}