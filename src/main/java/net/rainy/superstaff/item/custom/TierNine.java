package net.rainy.superstaff.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
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
// so yk like the DEATH BEAM , where a ray comes down then EVERYTHING IS GONE
    // that is what im trying do i will make the whole chunk dissapear
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {
            BlockHitResult hit = (BlockHitResult) user.raycast(50.0, 1.0F, false);
            BlockPos center = hit.getBlockPos();
            // XDDDDDDDDD i tried adding particles and a sound , BUT I think its too much for the game
            // they dont end up working , so i just removed them
            // would 200 blocks be good, PLS DONT CRASH MY PC PLS DONT CRASH MY PC
            ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD, user.getX(), user.getY() + 1, user.getZ()
                    , 20, 0.3, 0.5, 0.3, 0.01);
            ((ServerWorld) world).spawnParticles(ParticleTypes.SONIC_BOOM, user.getX(), user.getY() + 1, user.getZ()
                    , 20, 0.3, 0.5, 0.3, 0.01);
            world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_PORTAL_TRAVEL,SoundCategory.PLAYERS);
            ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY() + 1, user.getZ()
                    , 20, 0.3, 0.5, 0.3, 0.01);
            ((ServerWorld) world).spawnParticles(ParticleTypes.POOF, user.getX(), user.getY(), user.getZ()
                    , 15, 0.2, 0.2, 0.2, 0.02);
            // i can't lie , i copied that from tier ten , since i liked it so much
            for (int x = -20; x <= 24; x++) {
                for (int y = -200; y <= 200; y++) {
                    for (int z = -24; z <= 20; z++) {
                        BlockPos pos = center.add(x, y, z);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                    }}}
            // idk i couldn't find a suitable sound to choose
        }




        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}