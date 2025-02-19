package fr.kalipso.hexael.manager.nick.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class NickRemoveCommand extends ICommand {
    @Command(name="nick.remove", permissionNode = "essentials.nick")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getNickModule().removeNick(args.getPlayer());
    }
}
