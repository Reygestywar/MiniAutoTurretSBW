package tienmodpack.miniautoturret;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import tienmodpack.miniautoturret.entity.TurretM60Renderer;

@Mod(value = MiniAutoTurretMod.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MiniAutoTurretMod.MODID, value = Dist.CLIENT)
public class MiniAutoTurretModClient {
    public MiniAutoTurretModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MiniAutoTurretMod.TURRET_M60.get(), TurretM60Renderer::new);
    }
}