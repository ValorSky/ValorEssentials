package fr.kalipso.valorsky.manager.home.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class HomeDeleteCommand extends ICommand {
    @Command(name={"home.delete", "home.remove", "delhome"}, permissionNode = "essentials.home")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("&cSyntaxe: /delhome <nom>");
            return;
        }
        this.getInstance().getManager().getHomeModule().removeHome(args.getPlayer(), args.getArgs(0));
    }
}
