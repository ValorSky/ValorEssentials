package fr.kalipso.valorsky.manager.home.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class HomeCommand extends ICommand {
    @Command(name="home", permissionNode = "essentials.home")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0) {
            this.getInstance().getManager().getHomeModule().showHelp(args.getPlayer());
            return;
        }
        this.getInstance().getManager().getHomeModule().teleportHome(args.getPlayer(), args.getArgs(0));
    }
}
