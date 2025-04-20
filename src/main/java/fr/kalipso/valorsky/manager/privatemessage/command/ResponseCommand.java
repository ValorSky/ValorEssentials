package fr.kalipso.valorsky.manager.privatemessage.command;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResponseCommand extends Manager implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("response")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("§cVous devez éxécuter cet commande en jeu.");
                return false;
            }
            String msg = String.join(" ", args);
            msg.replace(args[0], "");
            Player player = (Player) commandSender;
            this.getInstance().getManager().getPrivateMessageManager().replyPM(player);
            return true;
        }
        return false;
    }
}
