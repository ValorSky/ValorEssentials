package fr.kalipso.hexael.manager.home.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

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
