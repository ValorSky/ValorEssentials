package fr.kalipso.hexael.manager.broadcast.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class PubCommand extends ICommand {

    @Command(name={"pub", "publicite"}, permissionNode = "essentials.pub", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getBroadcastModule().sendPub(args.getPlayer(), args);
    }
}
