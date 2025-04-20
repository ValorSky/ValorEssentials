package fr.kalipso.valorsky.manager.teleport.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class TeleportRequestCommand extends ICommand {
    @Command(name={"tpa", "tpto", "call"}, permissionNode = "essentials.tpa")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /call <joueur>");
            return;
        }
        this.getInstance().getManager().getTeleportModule().sendTeleportRequest(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }
}
