package fr.kalipso.valorsky.manager.top;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.TeleportationUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TopModule extends Manager {

    public void teleportTop(Player sender)
    {
        Location loc = new Location(sender.getWorld(), sender.getLocation().getX(), sender.getWorld().getHighestBlockYAt((int) sender.getLocation().getX(), (int) sender.getLocation().getZ()) + 1, sender.getLocation().getZ());
        TeleportationUtils.teleport(sender, loc, "§a§lEN HAUT");
    }
}
