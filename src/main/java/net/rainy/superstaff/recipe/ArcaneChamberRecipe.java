package net.rainy.superstaff.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record ArcaneChamberRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ArcaneChamberRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }


    @Override
    public boolean matches(ArcaneChamberRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(ArcaneChamberRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ARCANE_CHAMBER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ARCANE_CHAMBER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<ArcaneChamberRecipe> {
        public static final MapCodec<ArcaneChamberRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(ArcaneChamberRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ArcaneChamberRecipe::output)
        ).apply(inst, ArcaneChamberRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ArcaneChamberRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, ArcaneChamberRecipe::inputItem,
                        ItemStack.PACKET_CODEC, ArcaneChamberRecipe::output,
                        ArcaneChamberRecipe::new);

        @Override
        public MapCodec<ArcaneChamberRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ArcaneChamberRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}