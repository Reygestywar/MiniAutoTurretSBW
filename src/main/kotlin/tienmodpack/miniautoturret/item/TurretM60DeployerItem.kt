package tienmodpack.miniautoturret.item

import com.atsuishio.superbwarfare.item.misc.AbstractDeployerItem
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.level.Level
import tienmodpack.miniautoturret.MiniAutoTurretMod
import kotlin.math.cos
import kotlin.math.sin

class TurretM60DeployerItem(properties: Item.Properties) : AbstractDeployerItem(properties) {

    override fun spawnDeployedEntity(level: Level, player: Player): Entity {

        val turret = MiniAutoTurretMod.TURRET_M60.get().create(level)
            ?: throw IllegalStateException("Failed to create Turret M60 Entity")

        val yaw = Math.toRadians(player.yRot.toDouble())

        val distance = 2.0

        val x = player.x - sin(yaw) * distance
        val y = player.y
        val z = player.z + cos(yaw) * distance

        turret.setPos(x, y + 0.1, z)

        turret.yRot = player.yRot
        turret.yHeadRot = player.yRot

        if (!level.isClientSide) {
            level.addFreshEntity(turret)
        }

        return turret
    }
}