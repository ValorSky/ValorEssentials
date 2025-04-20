package fr.kalipso.valorsky.manager.enchant.command;


import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnchantCommand extends Manager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, String[] args) {
        if(command.getName().equalsIgnoreCase("enchant"))
        {
            if(!(commandSender instanceof Player))
            {
                commandSender.sendMessage("§cVous devez éxécuter cet commande en jeu.");
                return false;
            }
            this.getInstance().getManager().getEnchantModule().enchantItem((Player)commandSender, args[0], args[1]);
            return true;
        }
        return false;
    }
}
