package fr.kalipso.valorsky.manager.home.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class HomeSetCommand extends ICommand {
    @Command(name={"sethome", "home.create", "home.set"}, permissionNode = "essentials.home")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("&cSyntaxe: /sethome <nom>");
            return;
        }
        this.getInstance().getManager().getHomeModule().setHome(args.getPlayer(), args.getArgs(0));
    }
}
