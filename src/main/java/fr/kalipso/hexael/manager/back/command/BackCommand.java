package fr.kalipso.hexael.manager.back.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class BackCommand extends ICommand {
    @Command(name="back", permissionNode = "essentials.back")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getBackModule().backPlayer(args.getPlayer());
    }
}
