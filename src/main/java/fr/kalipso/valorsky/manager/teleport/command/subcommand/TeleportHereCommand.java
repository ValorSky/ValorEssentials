package fr.kalipso.valorsky.manager.teleport.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class TeleportHereCommand extends ICommand {
    @Command(name={"tphere", "teleporthere"}, permissionNode = "essentials.tphere")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /tphere <joueur/@all>");
            return;
        }
        if(args.getArgs(0).equalsIgnoreCase("@all"))
        {
            this.getInstance().getManager().getTeleportModule().teleportHereAllPlayer(args.getPlayer());
            return;
        }
        this.getInstance().getManager().getTeleportModule().teleportHerePlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }
}
