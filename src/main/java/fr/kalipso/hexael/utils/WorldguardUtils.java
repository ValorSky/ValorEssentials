package fr.kalipso.hexael.utils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class WorldguardUtils {
    private static boolean isRegion = false;



    public static boolean checkIfIsInRegion(Player player, String regionName)
    {
        com.sk89q.worldedit.util.Location loca = BukkitAdapter.adapt(player.getLocation());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(loca);
        AtomicBoolean value = new AtomicBoolean(false);
        set.forEach(rg -> {
            if(rg.getId().equals(regionName))
            {
                value.set(true);
            }
        });
        return value.get();
    }

    public static List<Location> getRegionBlocks(String worldName, String regionName) {
        World world = Bukkit.getWorld(worldName);
        RegionManager regionManager = WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(world));
        ProtectedRegion region = regionManager.getRegion(regionName);

        Location min = BukkitAdapter.adapt(world, region.getMinimumPoint());
        Location max = BukkitAdapter.adapt(world, region.getMaximumPoint());

        List<Location> locations = new ArrayList<>();
        for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
            for (int y = min.getBlockY(); y <= max.getBlockY(); y++) {
                for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
                    locations.add(new Location(world, x, y, z));
                }
            }
        }
        return locations;
    }

}
