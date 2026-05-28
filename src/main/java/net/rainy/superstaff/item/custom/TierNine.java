package net.rainy.superstaff.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TierNine extends Item {

    public TierNine(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {

            BlockHitResult hit = (BlockHitResult) user.raycast(50.0, 1.0F, false);
            BlockPos center = hit.getBlockPos();

            // 🔊 Beacon sound
            world.playSound(
                    null,
                    center,
                    SoundEvents.BLOCK_BEACON_ACTIVATE,
                    SoundCategory.BLOCKS
            );

            // ✨ Beacon particles
            for (int i = 0; i < 80; i++) {
                world.addParticle(
                        ParticleTypes.END_ROD,
                        center.getX() + 0.5,
                        center.getY() + 1,
                        center.getZ() + 0.5,
                        (world.random.nextDouble() - 0.5) * 0.2,
                        world.random.nextDouble() * 0.2,
                        (world.random.nextDouble() - 0.5) * 0.2
                );
            }
            // would 200 blocks be good, PLS DONT CRASH MY PC PLS DONT CRASH MY PC
            for (int x = -16; x <= 16; x++) {
                for (int y = -200; y <= 200; y++) {
                    for (int z = -16; z <= 16; z++) {
                        BlockPos pos = center.add(x, y, z);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                    }}}
            // idk i couldn't find a suitable sound to choose
            world.playSound(null, center, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.BLOCKS);
        }




        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}