package fr.kalipso.valorsky.manager.home.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class HomeListCommand extends ICommand {
    @Command(name={"homes", "home.list"}, permissionNode = "essentials.home")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getHomeModule().showList(args.getPlayer());
    }
}
