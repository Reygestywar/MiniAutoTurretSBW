package tienmodpack.miniautoturret;

import com.atsuishio.superbwarfare.entity.projectile.ProjectileEntity;
import com.atsuishio.superbwarfare.item.container.ContainerBlockItem;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import tienmodpack.miniautoturret.entity.TurretM60Entity;

@Mod(MiniAutoTurretMod.MODID)
public class MiniAutoTurretMod {

    public static final String MODID = "mini_auto_turret";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MODID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<TurretM60Entity>> TURRET_M60 =
            ENTITY_TYPES.register("turret_m60",
                    () -> EntityType.Builder
                            .of(TurretM60Entity::new, MobCategory.MISC)
                            .sized(0.8F, 0.8F)
                            .build("turret_m60"));

    public static final DeferredHolder<EntityType<?>, EntityType<ProjectileEntity>> M60_TRACER =
            ENTITY_TYPES.register("m60_tracer",
                    () -> EntityType.Builder
                            .<ProjectileEntity>of(ProjectileEntity::new, MobCategory.MISC)
                            .sized(0.1F, 0.1F)
                            .noSave()
                            .fireImmune()
                            .clientTrackingRange(64)
                            .updateInterval(1)
                            .build("m60_tracer"));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB =
            CREATIVE_TABS.register("main",
                    () -> CreativeModeTab.builder()
                            .title(Component.literal("Mini Auto Turret"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> ContainerBlockItem.createInstance(TURRET_M60.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ContainerBlockItem.createInstance(TURRET_M60.get()));
                            })
                            .build());

    public MiniAutoTurretMod(IEventBus modBus, ModContainer container) {
        ITEMS.register(modBus);
        ENTITY_TYPES.register(modBus);
        CREATIVE_TABS.register(modBus);

        LOGGER.info("Mini Auto Turret Loaded.");
    }
}