package fr.kalipso.valorsky.manager.list.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class ListCommand extends ICommand {


    @Command(name="list", permissionNode = "essentials.list")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getListModule().sendList(args.getPlayer());
    }
}
