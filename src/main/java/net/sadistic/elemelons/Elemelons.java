package net.sadistic.elemelons;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sadistic.elemelons.items.*;
import org.slf4j.Logger;

@Mod(Elemelons.MODID)
public class Elemelons {
    public static final String MODID = "elemelons";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Item> EARTH_MELON = ITEMS.register("earth_melon", () -> new EarthMelon(EarthMelon.ITEM_PROPERTIES));
    public static final RegistryObject<Item> FIRE_MELON = ITEMS.register("fire_melon", () -> new FireMelon(FireMelon.ITEM_PROPERTIES));
    public static final RegistryObject<Item> WATER_MELON = ITEMS.register("water_melon", () -> new WaterMelon(WaterMelon.ITEM_PROPERTIES));
    public static final RegistryObject<Item> WIND_MELON = ITEMS.register("wind_melon", () -> new WindMelon(WindMelon.ITEM_PROPERTIES));
    public static final RegistryObject<Item> TRADERS_MELON = ITEMS.register("traders_melon", () -> new TradersMelon(TradersMelon.ITEM_PROPERTIES));
    public static final RegistryObject<Item> MINERS_MELON = ITEMS.register("miners_melon", () -> new MinersMelon(MinersMelon.ITEM_PROPERTIES));
    //public static final RegistryObject<Item> SATURATED_MELON = ITEMS.register("saturated_melon", () -> new SaturatedMelon(SaturatedMelon.ITEM_PROPERTIES));


    public static final RegistryObject<CreativeModeTab> ELEMELONS_TAB = CREATIVE_MODE_TABS.register("elemelons", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + MODID + ".main"))
            .icon(() -> new ItemStack(EARTH_MELON.get()))
            .displayItems((parameters, output) -> {
                output.accept(EARTH_MELON.get());
                output.accept(FIRE_MELON.get());
                output.accept(WATER_MELON.get());
                output.accept(WIND_MELON.get());
                output.accept(TRADERS_MELON.get());
                output.accept(MINERS_MELON.get());
                //output.accept(SATURATED_MELON.get());
            })
            .build());

    public Elemelons() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Loading EleMelons");

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Loaded Elemelons v1.0.0");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("Loaded Elemelons v1.0.0");
        }
    }
}
