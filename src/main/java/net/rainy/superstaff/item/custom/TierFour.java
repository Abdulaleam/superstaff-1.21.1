package net.rainy.superstaff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TierFour extends Item {

    public TierFour(Settings settings) {
        super(settings);
    }

    // UGHHHHH do i make it like each staff a ability instead of tiers I HAVE NO IDEA
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {
            // PLS WORK MY PRECIOUS FIREBALL , LIGHTING WAS SO MUCH EASIER to find out

            if (user.hasStatusEffect(StatusEffects.LEVITATION)) {
                user.removeStatusEffect(StatusEffects.STRENGTH);
                user.removeStatusEffect(StatusEffects.SPEED);
                user.removeStatusEffect(StatusEffects.LEVITATION);
                // ehhhhhhhhhhhhh alr that works
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);




            } else {

                // Credits to hazoro for saivng me , as im suffering
                // i couldnt make the fireball work , so i looked around for an hour
                // I MADE IT WORK but it shows a snow ball
                // update 4 the fireball now works i changed it from a snowball thanks to hazoro BUT ITS SMALL
                // UPDATE 5 brh im tired , pls work , it didnot work

                Vec3d look = user.getRotationVec(1.0F);

                SmallFireballEntity fireball = new SmallFireballEntity(world, user.getX(), user.getEyeY(), user.getZ(), look)
                {

                    @Override
                    protected void onBlockHit(BlockHitResult hit) {
                        super.onBlockHit(hit);
                        world.createExplosion(this, getX(), getY(), getZ(), 6F, World.ExplosionSourceType.MOB);}
                    //  note: 8F seems to make weird sounds so i made it 5



                };

                fireball.setOwner(user);
                fireball.setVelocity(look.x, look.y, look.z, 1.5F, 0.0F);
                world.spawnEntity(fireball);
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS);

                // would tnt sound be better?
                // pls work i wasted alot of time here
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}