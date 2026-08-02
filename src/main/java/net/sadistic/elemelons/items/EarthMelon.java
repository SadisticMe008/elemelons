package net.sadistic.elemelons.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class EarthMelon {

    public static float SATURATION = 0.5f;
    public static int NUTRITION = 5;

    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(NUTRITION).saturationMod(SATURATION)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 2), 1f)
            .build();

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().food(FOOD_PROPERTIES);

}
