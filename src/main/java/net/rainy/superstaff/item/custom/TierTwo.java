package net.rainy.superstaff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TierTwo extends Item {
    public TierTwo(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            if (user.hasStatusEffect(StatusEffects.LEVITATION)) {
                user.removeStatusEffect(StatusEffects.STRENGTH);
                user.removeStatusEffect(StatusEffects.SPEED);
                user.removeStatusEffect(StatusEffects.LEVITATION);
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);



            } else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2000, 1
                ));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 1
                ));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2000, 1
                ));
                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE,
                        SoundCategory.PLAYERS);

            }}return TypedActionResult.success(stack, world.isClient());


    }
}
