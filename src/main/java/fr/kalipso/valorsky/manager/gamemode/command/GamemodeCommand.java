package fr.kalipso.valorsky.manager.gamemode.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class GamemodeCommand extends ICommand {
    @Command(name={"gamemode", "gm"}, permissionNode = "essentials.gamemode")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /gamemode <name> [player]");
        }
        else if(args.length() == 1)
        {
            this.getInstance().getManager().getGamemodeModule().changeGamemode(args.getPlayer(), args.getArgs(0));
        }
        else
        {
            this.getInstance().getManager().getGamemodeModule().changeGamemodeOther(args.getPlayer(), Bukkit.getPlayer(args.getArgs(1)), args.getArgs(0));

        }
    }
}