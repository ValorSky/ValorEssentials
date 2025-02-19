package fr.kalipso.hexael.manager.condense.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class CondenseCommand extends ICommand {
    @Command(name="condense", permissionNode = "essentials.condense")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getCondenseModule().condense(args.getPlayer());
    }
}
