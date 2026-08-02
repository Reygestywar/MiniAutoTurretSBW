package tienmodpack.miniautoturret;

import com.atsuishio.superbwarfare.item.container.ContainerBlockItem;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import tienmodpack.miniautoturret.entity.TurretM60Entity;
import tienmodpack.miniautoturret.item.TurretM60DeployerItem;

@Mod(MiniAutoTurretMod.MODID)
public class MiniAutoTurretMod {

    public static final String MODID = "mini_auto_turret";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<EntityType<TurretM60Entity>> TURRET_M60 =
            ENTITY_TYPES.register("turret_m60",
                    () -> EntityType.Builder
                            .of(TurretM60Entity::new, MobCategory.MISC)
                            .sized(0.8F, 0.8F)
                            .build("turret_m60"));

    public static final RegistryObject<TurretM60DeployerItem> TURRET_M60_DEPLOYER =
            ITEMS.register("turret_m60_deployer",
                    () -> new TurretM60DeployerItem(
                            new Item.Properties().stacksTo(1)
                    ));

    public static final RegistryObject<CreativeModeTab> MAIN_TAB =
            CREATIVE_TABS.register("main",
                    () -> CreativeModeTab.builder()
                            .title(Component.literal("Mini Auto Turret"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> ContainerBlockItem.createInstance(TURRET_M60.get()))
                            .displayItems((parameters, output) -> {

                                output.accept(ContainerBlockItem.createInstance(TURRET_M60.get()));

                            })
                            .build());

    public MiniAutoTurretMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modBus);
        ENTITY_TYPES.register(modBus);
        CREATIVE_TABS.register(modBus);

        LOGGER.info("Mini Auto Turret Loaded.");
    }

}