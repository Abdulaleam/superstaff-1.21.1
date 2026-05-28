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
import net.minecraft.world.World;

public class TierTen extends Item {
    public TierTen(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
// ezzzzzzz im out of idea , SO INVISBILITY IT IS!!!!!!!!!!!!!!!!!!!
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            if (user.hasStatusEffect(StatusEffects.INVISIBILITY)) {
                user.removeStatusEffect(StatusEffects.STRENGTH);
                user.removeStatusEffect(StatusEffects.SPEED);
                user.removeStatusEffect(StatusEffects.LEVITATION);
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);
                user.removeStatusEffect(StatusEffects.INVISIBILITY);



// idk what else to add , I THINK IM GOOD TO GO
            } else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2000, 1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 2000, 1));
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT,SoundCategory.PLAYERS);
                ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY() + 1, user.getZ()
                        , 20, 0.3, 0.5, 0.3, 0.01);

                ((ServerWorld) world).spawnParticles(ParticleTypes.POOF, user.getX(), user.getY(), user.getZ()
                        , 15, 0.2, 0.2, 0.2, 0.02);
                // WTH is the Woof particle , holy i wanna check it in game i found it while looking in the particles types
                // update I LIKE IT , not removing it
            }}return TypedActionResult.success(stack, world.isClient());


    }
}
