package tienmodpack.miniautoturret.entity

import net.minecraft.client.renderer.entity.EntityRendererProvider
import software.bernie.geckolib.renderer.GeoEntityRenderer

class TurretM60Renderer(context: EntityRendererProvider.Context) :
    GeoEntityRenderer<TurretM60Entity>(context, TurretM60EntityModel())