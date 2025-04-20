package fr.kalipso.valorsky.manager.teleport.command;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand extends Manager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(command.getName().equalsIgnoreCase("teleport")) {
            if (strings.length == 0) {
                this.getInstance().getManager().getTeleportModule().showHelp((Player) commandSender);
                return false;
            }
            if (commandSender instanceof Player) {
                this.getInstance().getManager().getTeleportModule().teleportToPlayer((Player) commandSender, Bukkit.getPlayer(strings[0]));
                return true;
            }
        }
        return false;
    }
}
