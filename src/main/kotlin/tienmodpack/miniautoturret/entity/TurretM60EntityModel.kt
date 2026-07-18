package tienmodpack.miniautoturret.entity

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel
import net.minecraft.resources.ResourceLocation
import tienmodpack.miniautoturret.MiniAutoTurretMod

class TurretM60EntityModel : VehicleModel<TurretM60Entity>() {

    override fun collectTransform(boneName: String): TransformContext<TurretM60Entity>? {
        return when (boneName) {
            "root" -> TransformContext { bone, vehicle, _ ->
                bone.rotY = -vehicle.yRot * (Math.PI.toFloat() / 180f)
            }
            "turret" -> TransformContext { bone, _, _ ->
                bone.rotY = turretYRot * (Math.PI.toFloat() / 180f)
            }
            else -> super.collectTransform(boneName)
        }
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getModelResource(vehicle: TurretM60Entity): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(
            MiniAutoTurretMod.MODID,
            "geo/turret_m60.geo.json"
        )

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getTextureResource(vehicle: TurretM60Entity): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(
            MiniAutoTurretMod.MODID,
            "textures/entity/turret_m60.png"
        )

    override fun getAnimationResource(vehicle: TurretM60Entity): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(
            MiniAutoTurretMod.MODID,
            "animations/turret_m60.animation.json"
        )
}