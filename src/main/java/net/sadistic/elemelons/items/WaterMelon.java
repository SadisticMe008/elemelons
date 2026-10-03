package net.sadistic.elemelons.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WaterMelon extends Item{

    public static float SATURATION = 0.5f;
    public static int NUTRITION = 5;

    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(NUTRITION).saturationMod(SATURATION)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 600), 1f)
            .build();

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().food(FOOD_PROPERTIES);

    public WaterMelon(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> component, TooltipFlag flag) {
        super.appendHoverText(stack, level, component, flag);
        String[] tooltip = Component.translatable("item.elemelons.water_melon.tooltip").getString().split("\n");
        for(int i = 0; i < tooltip.length; i++) {
            component.add(Component.literal(tooltip[i]));
        }
    }
}
