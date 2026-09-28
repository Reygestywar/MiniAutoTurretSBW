package tienmodpack.miniautoturret.entity

import com.atsuishio.superbwarfare.entity.vehicle.base.AutoAimableEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.Level
import software.bernie.geckolib.animatable.GeoAnimatable
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.animation.AnimationController
import software.bernie.geckolib.animation.RawAnimation
import software.bernie.geckolib.util.GeckoLibUtil

class TurretM60Entity(
    type: EntityType<out AutoAimableEntity>,
    level: Level
) : AutoAimableEntity(type, level), GeoAnimatable {

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)
    private var hasSnappedToCenter = false

    override fun registerControllers(data: AnimatableManager.ControllerRegistrar) {
        data.add(
            AnimationController(this, "main_controller", 0) { state ->
                if (getShootAnimationTimer(0, 0) > 0) {
                    state.setAndContinue(RawAnimation.begin().thenPlay("animation.turret_m60.fire"))
                } else {
                    state.setAndContinue(RawAnimation.begin().thenLoop("animation.turret_m60.idle"))
                }
            }
        )
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return cache
    }

    override fun getTick(animatable: Any?): Double {
        return this.tickCount.toDouble()
    }

    override fun tick() {
        super.tick()
        setDeltaMovement(0.0, 0.0, 0.0)
        noPhysics = true

        if (!level().isClientSide && !hasSnappedToCenter && this.tickCount < 5) {
            val blockPos = BlockPos.containing(this.x, this.y, this.z)
            val centerX = blockPos.x + 0.5
            val centerZ = blockPos.z + 0.5

            this.moveTo(centerX, this.y, centerZ)
            hasSnappedToCenter = true
        }
    }
}
