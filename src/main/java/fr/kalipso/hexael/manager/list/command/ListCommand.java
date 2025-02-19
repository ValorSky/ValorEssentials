package fr.kalipso.hexael.manager.list.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class ListCommand extends ICommand {


    @Command(name="list", permissionNode = "essentials.list")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getListModule().sendList(args.getPlayer());
    }
}
