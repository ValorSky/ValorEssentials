package fr.kalipso.hexael.manager.home.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

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
