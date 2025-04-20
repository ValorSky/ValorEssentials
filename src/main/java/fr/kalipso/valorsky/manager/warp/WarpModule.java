package fr.kalipso.valorsky.manager.warp;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.warp.factory.Warp;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.TeleportationUtils;
import fr.kalipso.valorsky.utils.object.CustomLocation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WarpModule extends Manager {

    public void teleportWarp(Player sender, String name)
    {
        if(!this.getInstance().getManager().getDataManager().getServer().getWarps().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("warp-no-exist"));
            return;
        }
        if(!sender.hasPermission("essentials.warp." + name))
        {
            sender.sendMessage(MessageUtils.sendError("no-permission"));
            return;
        }
        TeleportationUtils.teleport(sender, this.getInstance().getManager().getDataManager().getServer().getWarps().get(name).getCustomLocation().toLocation(), name.toUpperCase());
    }

    public void createWarp(Player sender, String name)
    {
        if(this.getInstance().getManager().getDataManager().getServer().getWarps().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("warp-exist"));
            return;
        }
        Warp warp = new Warp(name, new CustomLocation(sender.getWorld().getName(), sender.getLocation().getBlockX(), sender.getLocation().getBlockY(), sender.getLocation().getBlockZ()));
        this.getInstance().getManager().getDataManager().getServer().getWarps().put(name, warp);
        sender.sendMessage(MessageUtils.sendMessage("warp-create").replace("%name%", name));
    }

    public void deleteWarp(Player sender, String name)
    {
        if(!this.getInstance().getManager().getDataManager().getServer().getWarps().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("warp-no-exist"));
            return;
        }
        this.getInstance().getManager().getDataManager().getServer().getWarps().remove(name);
        sender.sendMessage(MessageUtils.sendMessage("warp-delete").replace("%name%", name));
    }

    public void sendList(Player sender)
    {
        List<String> msg = new ArrayList<>();
        msg.add("§7§m-----------------");
        msg.add("");
        for(String name : this.getInstance().getManager().getDataManager().getServer().getWarps().keySet())
        {
            msg.add("§b§l" + name);
        }
        msg.add("");
        msg.add("§7§m-----------------");


            msg.forEach(line -> {
                sender.sendMessage(line);

        });
    }

    public void sendHelp(Player sender)
    {
        sender.sendMessage("§7§m------------------");
        sender.sendMessage("");
        sender.sendMessage("§f/warp §7- §bAffiche l'aide des warp");
        sender.sendMessage("§f/warp <nom> §7- §bTéléporte au warp");
        sender.sendMessage("§f/warp list §7- §bAffiche la liste des warps");
        sender.sendMessage("§f/warp create <nom> §7- §bCrée un warp");
        sender.sendMessage("§f/warp delete <nom> §7- §bSupprime un warp");
        sender.sendMessage("");
        sender.sendMessage("§7§m------------------");
    }

    public void teleportWarpPlayer(Player target, CommandSender sender, String name) {
        if(!this.getInstance().getManager().getDataManager().getServer().getWarps().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("warp-no-exist"));
            return;
        }
        if(!sender.hasPermission("essentials.warp." + name))
        {
            sender.sendMessage(MessageUtils.sendError("no-permission"));
            return;
        }
        TeleportationUtils.teleport(target, this.getInstance().getManager().getDataManager().getServer().getWarps().get(name).getCustomLocation().toLocation(), name.toUpperCase());
    }
}
