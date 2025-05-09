package fr.kalipso.valorsky.manager.home.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class HomeSetmaxCommand extends ICommand {
    @Command(name="home.setmax", permissionNode = "essentials.admin", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 2)
        {
            args.getSender().sendMessage("§cSyntaxe: /home setmax <player> <value>");
            return;
        }
        this.getInstance().getManager().getHomeModule().setMax(args.getSender(), args.getArgs(0), args.getArgs(1));
    }
}
