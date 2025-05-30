package fr.kalipso.valorsky.manager.privatemessage.command;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PrivateMessageCommand extends Manager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, String[] args) {
        if(command.getName().equalsIgnoreCase("msg"))
        {
            if(!(commandSender instanceof Player))
            {
                commandSender.sendMessage("§cVous devez éxécuter cet commande en jeu.");
                return false;
            }
            String msg = String.join(" ", args);
            msg.replace(args[0], "");
            Player player = (Player) commandSender;
            this.getInstance().getManager().getPrivateMessageManager().sendPM(player, Bukkit.getPlayer(args[0]), msg);
            return true;
        }
        return false;
    }
}
