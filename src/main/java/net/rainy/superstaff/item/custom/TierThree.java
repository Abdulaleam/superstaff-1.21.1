package net.rainy.superstaff.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class TierThree extends Item {
    public TierThree(Settings settings) {
        super(settings);
    }
 // UGHHHHH do i make it like each staff a ability instead of tiers I HAVE NO IDEA
 @Override

 public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {if (!world.isClient()) {

         // UGHHHHH do i make it like each staff a ability instead of tiers I HAVE NO IDEA

         if (user.hasStatusEffect(StatusEffects.LEVITATION)) {
             user.removeStatusEffect(StatusEffects.STRENGTH);
             user.removeStatusEffect(StatusEffects.SPEED);
             user.removeStatusEffect(StatusEffects.LEVITATION);
             user.removeStatusEffect(StatusEffects.NIGHT_VISION);


         } else {

             // lets jsut go with this setup instead of each ability a staff
             user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 2));
             user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2000, 2));

             world.playSound(null, user.getBlockPos(),
                     SoundEvents.ENTITY_TNT_PRIMED,
                     SoundCategory.PLAYERS);

             BlockHitResult hit = (BlockHitResult) user.raycast(100, 0, false);

             LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);

             if (lightning != null) {

                 lightning.setPosition(hit.getPos());
                 world.spawnEntity(lightning);

                 // this shit took too long i swear , but i found it out
                 // I HOPE I REMEMBER TO MAKE A CUSTOM SOUND EVENT FOR THIS OR SMTH
             }
         }
     }

     return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
 }}