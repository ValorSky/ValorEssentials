package fr.kalipso.valorsky.manager.border;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class BorderModule extends Manager {

    public BorderModule()
    {
        this.setSpawnBorder();
    }

    public void setSpawnBorder()
    {
        World world = Bukkit.getWorld(this.getInstance().getManager().getConfigManager().get("main").getString("spawn-world"));
        world.getWorldBorder().setCenter(new Location(world, this.getInstance().getManager().getConfigManager().get("main").getDouble("spawn-border-x"), this.getInstance().getManager().getConfigManager().get("main").getDouble("spawn-border-y"), this.getInstance().getManager().getConfigManager().get("main").getDouble("spawn-border-z")));
        world.getWorldBorder().setSize(this.getInstance().getManager().getConfigManager().get("main").getDouble("spawn-border"));
    }
}
