package tienmodpack.miniautoturret.entity

import com.atsuishio.superbwarfare.entity.vehicle.base.AutoAimableEntity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.Level
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.animation.AnimationController
import software.bernie.geckolib.animation.RawAnimation

class TurretM60Entity(
    type: EntityType<out AutoAimableEntity>,
    level: Level
) : AutoAimableEntity(type, level) {

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

    override fun tick() {
        super.tick()
        setDeltaMovement(0.0, 0.0, 0.0)
        noPhysics = true
    }
}