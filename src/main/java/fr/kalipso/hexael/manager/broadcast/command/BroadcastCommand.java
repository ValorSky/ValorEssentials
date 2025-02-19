package fr.kalipso.hexael.manager.broadcast.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class BroadcastCommand extends ICommand {

    @Command(name={"bc", "broadcast", "annonce"}, permissionNode = "essentials.broadcast", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getBroadcastModule().sendBroadcast(args.getSender(), args);
    }
}
