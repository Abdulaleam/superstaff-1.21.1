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

public class TierOne extends Item {
    public TierOne(Settings settings) {
        super(settings);
    }
 // Alr so what im planning is Adding a Tier 1 staff that like gives super effects
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
// this is the easiest way till now i found to do it if we already have the leviation clicking again would remove it
            // issue is IDK if i will make it more than 1 effect in the future EHHHHHHHH
            if (user.hasStatusEffect(StatusEffects.LEVITATION)) {
                user.removeStatusEffect(StatusEffects.STRENGTH);
                user.removeStatusEffect(StatusEffects.SPEED);
                user.removeStatusEffect(StatusEffects.LEVITATION);
                user.removeStatusEffect(StatusEffects.NIGHT_VISION);




            } else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2000, 0
                ));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 0
                ));
                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE,
                        SoundCategory.PLAYERS);

            }}return TypedActionResult.success(stack, world.isClient());


    }
}
