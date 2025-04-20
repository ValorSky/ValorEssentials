package fr.kalipso.valorsky.manager.top.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class TopCommand extends ICommand {
    @Command(name="top", permissionNode = "essentials.top")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getTopModule().teleportTop(args.getPlayer());
    }
}
