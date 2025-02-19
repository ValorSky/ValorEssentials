package fr.kalipso.hexael.utils.object;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;

public class CustomChunk {

    private String world;
    private int x,z;

    public CustomChunk(String world, int x, int z)
    {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    public String toString()
    {
        return world + ";" + x + ";" + z;
    }

    public static Chunk fromString(String serialized)
    {
        String[] splited = serialized.split(";");
        return Bukkit.getWorld(splited[0]).getChunkAt(Chunk.getChunkKey(Integer.valueOf(splited[1]), Integer.valueOf(splited[2])));
    }
}
