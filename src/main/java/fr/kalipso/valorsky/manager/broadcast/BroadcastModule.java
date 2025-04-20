package fr.kalipso.valorsky.manager.broadcast;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.StringUtils;
import fr.kalipso.valorsky.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastModule extends Manager {

    public void sendBroadcast(CommandSender sender, CommandArgs args)
    {
        String annonce = StringUtils.joinArray(args.getArgs(), " ", 1);
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("");
            player.sendMessage(annonce);
            player.sendMessage("    §7@§b§l" + sender.getName());
            player.sendMessage("");
        });
    }

    public void sendPub(Player sender, CommandArgs args)
    {
        String annonce = StringUtils.joinArray(args.getArgs(), " ", 1);
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("§7§m-----------------------");
            player.sendMessage("    §a§lPUBLICITE DE §f" + sender.getName());
            player.sendMessage("");
            player.sendMessage(annonce);
            player.sendMessage("");
            player.sendMessage("§7§m-----------------------");
        });
    }
}
