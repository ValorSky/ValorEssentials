package fr.kalipso.valorsky.manager.teleport;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.teleport.factory.TeleportRequest;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.TeleportationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TeleportModule extends Manager {

    private HashMap<Player, TeleportRequest> teleportRequest = new HashMap<>();
    public void teleportToCoords(Player sender, int x, int y, int z)
    {
        World world = sender.getWorld();
        Location loc = new Location(world, x, y, z);
        String name = "X:" + x + ", Y:" + y + " ,Z:"+ z;
        TeleportationUtils.teleport(sender, loc, name);
    }

    public void teleportToPlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        TeleportationUtils.teleport(sender, target.getLocation(), target.getName());
    }

    public void teleportHerePlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        TeleportationUtils.teleport(target, sender.getLocation(), sender.getName());
        sender.sendMessage(MessageUtils.sendMessage("teleport-here").replace("%target%", target.getName()));
    }

    public void teleportHereAllPlayer(Player sender)
    {
        if(Bukkit.getOnlinePlayers().size() < 2)
        {
            sender.sendMessage(MessageUtils.sendError("no-online-player"));
            return;
        }
        Bukkit.getOnlinePlayers().forEach(player -> {
            if(player == sender)return;
            TeleportationUtils.teleport(player, sender.getLocation(), sender.getName());
        });
        sender.sendMessage(MessageUtils.sendMessage("teleport-here-all"));

    }

    public void sendTeleportRequest(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(teleportRequest.containsKey(target))
        {
            teleportRequest.remove(target);
            teleportRequest.put(target, new TeleportRequest(sender, target));
            return;
        }
        teleportRequest.put(target, new TeleportRequest(sender, target));
        sender.sendMessage(MessageUtils.sendMessage("teleport-request-send").replace("%target%", target.getName()));
        this.getInstance().getManager().getConfigManager().get("messages").getStringList("teleport-request-receive").forEach(line -> {
            target.sendMessage(line.replace("%sender%", sender.getName())
                    .replace("%target%", target.getName()));
        });
    }

    public void acceptTeleportRequest(Player sender)
    {
        if(!teleportRequest.containsKey(sender))
        {
            sender.sendMessage(MessageUtils.sendError("teleport-request-no-have"));
            return;
        }
        TeleportRequest teleport = teleportRequest.get(sender);
        TeleportationUtils.teleport(teleport.getSender(), sender.getLocation(), sender.getName());
        sender.sendMessage(MessageUtils.sendMessage("teleport-accept"));
    }

    public void denyTeleportRequest(Player sender)
    {
        if(!teleportRequest.containsKey(sender))
        {
            sender.sendMessage(MessageUtils.sendError("teleport-request-no-have"));
            return;
        }
        teleportRequest.remove(sender);
        sender.sendMessage(MessageUtils.sendMessage("teleport-deny"));
    }

    public void showHelp(Player sender)
    {
        sender.sendMessage("§7§m------------------");
        sender.sendMessage("");
        sender.sendMessage("§f/teleport §7- §bAffiche l'aide des téléporations");
        sender.sendMessage("§f/teleport <joueur> §7- §bTéléporte à un joueur");
        sender.sendMessage("§f/tpcoords <x> <y> <z>§7- §bTéléporte à des coordonnées");
        sender.sendMessage("§f/tphere <joueur/@all>§7- §bTéléporte un joueur vers toi");
        sender.sendMessage("§f/call <joueur>§7- §bEnvoie une demande de téléportation");
        sender.sendMessage("§f/tpyes <joueur>§7- §bAccept une demande de téléporation");
        sender.sendMessage("§f/tpno <joueur>§7- §bRefuse une demande de téléportation");
        sender.sendMessage("");
        sender.sendMessage("§7§m------------------");
    }
}
