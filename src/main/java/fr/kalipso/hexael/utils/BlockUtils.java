package fr.kalipso.hexael.utils;

import org.bukkit.Chunk;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class BlockUtils {


    public static void spawnParticles(Player sender, Chunk c)
    {
        World world = c.getWorld();
        int chunkX = (int) c.getX();
        int chunkZ = (int) c.getZ();
        int minX = chunkX * 16;
        int minZ = chunkZ * 16;
        for (int x = minX; x < minX + 16; x++)
        {
            sender.spawnParticle(Particle.WHITE_SMOKE, x, sender.getLocation().getY(), minZ, 10);
        }
    }
}
