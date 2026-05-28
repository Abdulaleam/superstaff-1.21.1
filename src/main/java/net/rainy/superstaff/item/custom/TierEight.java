package net.rainy.superstaff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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

public class TierEight extends Item {
    // ez teleporter staff aqquired 8/10
    // alr so my first thought was make like an ender pearl or snow ball that when block hit  tp
    // BUT THAT IS SO BASIC like that is just an ender pearl . so nah INSTA TP Baby
    public TierEight(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 100));
            // I ADDED THIS COZ , I KEPT DYING WHEN USING THE TP STICK THING
            Vec3d start = user.getCameraPosVec(1.0F);
            Vec3d direction = user.getRotationVec(1.0F);
            Vec3d end = start.add(direction.multiply(50)); // range

            BlockHitResult hit = world.raycast(
                    new net.minecraft.world.RaycastContext(start, end, net.minecraft.world.RaycastContext.ShapeType.OUTLINE, net.minecraft.world.RaycastContext.FluidHandling.NONE, user));
            BlockPos pos = hit.getBlockPos();
            user.requestTeleport(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5
            );
            ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD, user.getX(), user.getY() + 1, user.getZ()
                    , 20, 0.3, 0.5, 0.3, 0.01);
            ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY() + 1, user.getZ()
                    , 20, 0.3, 0.5, 0.3, 0.01);
            ((ServerWorld) world).spawnParticles(ParticleTypes.POOF, user.getX(), user.getY(), user.getZ()
                    , 15, 0.2, 0.2, 0.2, 0.02);

            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS);
            // i think this good , i might not even need to make a custom sound event for it later on



        }return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }}