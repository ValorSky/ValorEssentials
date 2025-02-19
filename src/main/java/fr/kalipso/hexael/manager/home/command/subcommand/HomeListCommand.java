package fr.kalipso.hexael.manager.home.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class HomeListCommand extends ICommand {
    @Command(name={"homes", "home.list"}, permissionNode = "essentials.home")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getHomeModule().showList(args.getPlayer());
    }
}
