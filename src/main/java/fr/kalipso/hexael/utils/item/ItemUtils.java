package fr.kalipso.hexael.utils.item;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemUtils {

    public static boolean isAffected(Material material) {
        return material == Material.DIRT || material == Material.GRASS_BLOCK || material == Material.STONE || material == Material.COBBLESTONE || material == Material.COAL_ORE || material == Material.DIAMOND_ORE || material == Material.EMERALD_ORE || material == Material.GOLD_ORE || material == Material.IRON_ORE || material == Material.LAPIS_ORE || material == Material.NETHER_QUARTZ_ORE || material == Material.REDSTONE_ORE;
    }
    public static boolean isInProtectedTerritory(Player player, Location location) {
        if (player == null) {
            return false;
        } else {
            RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
            com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(location);
            return !query.testState(loc, WorldGuardPlugin.inst().wrapPlayer(player), new StateFlag[]{Flags.BUILD});
        }
    }

}
