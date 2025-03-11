package fr.kalipso.hexael.manager.spawn;

import fr.kalipso.hexael.data.server.factory.ProfileServer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.TeleportationUtils;
import fr.kalipso.hexael.utils.object.CustomLocation;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnModule extends Manager {


    public void teleportSpawn(Player sender)
    {
        if(this.getInstance().getManager().getDataManager().getServer().getSpawnLocation() == null)
        {
            sender.sendMessage(MessageUtils.sendError("spawn-no-location"));
            return;
        }
        if(!sender.hasPermission("essentials.teleport.bypass") || !sender.isOp())
        {
            TeleportationUtils.teleportCooldown(sender, this.getInstance().getManager().getDataManager().getServer().getSpawnLocation().toLocation(), "Spawn");
            return;
        }
        TeleportationUtils.teleport(sender, this.getInstance().getManager().getDataManager().getServer().getSpawnLocation().toLocation(), "Spawn");
    }

    public void teleportSpawn(CommandSender sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(this.getInstance().getManager().getDataManager().getServer().getSpawnLocation() == null)
        {
            sender.sendMessage(MessageUtils.sendError("spawn-no-location"));
            return;
        }
        TeleportationUtils.teleport(target, this.getInstance().getManager().getDataManager().getServer().getSpawnLocation().toLocation(), "Spawn");
        sender.sendMessage(MessageUtils.sendMessage("teleport-other")
                .replace("%target%", target.getName())
                .replace("%name%", "Spawn"));
    }

    public void teleport(Player sender)
    {
        ProfileServer server = this.getInstance().getManager().getDataManager().getServer();
        if(server.getSpawnLocation() == null)
        {
            return;
        }
        sender.teleport(server.getSpawnLocation().toLocation());
    }

    public void setSpawn(Player sender, Location loc)
    {
        if(loc == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-location"));
            return;
        }
        CustomLocation spawnLocation = new CustomLocation(loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        this.getInstance().getManager().getDataManager().getServer().setSpawnLocation(spawnLocation);
        this.getInstance().getManager().getDataManager().getProfileServer().save();
        spawnLocation.toLocation().getWorld().setSpawnLocation(loc);
        sender.sendMessage(MessageUtils.sendMessage("spawn-set"));
    }


}
