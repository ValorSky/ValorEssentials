package fr.kalipso.valorsky.manager.broadcast.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class BroadcastCommand extends ICommand {

    @Command(name={"bc", "broadcast", "annonce"}, permissionNode = "essentials.broadcast", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getBroadcastModule().sendBroadcast(args.getSender(), args);
    }
}
