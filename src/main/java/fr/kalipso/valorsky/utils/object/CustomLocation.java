package fr.kalipso.valorsky.utils.object;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public @Data class CustomLocation {

    private String world;
    private double x, y, z;

    public CustomLocation(String world, double x, double y, double z)
    {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location toLocation()
    {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public static CustomLocation fromLocation(Location loc)
    {
        return new CustomLocation(loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ());
    }

    public World getWorld()
    {
        return Bukkit.getWorld(world);
    }


}
