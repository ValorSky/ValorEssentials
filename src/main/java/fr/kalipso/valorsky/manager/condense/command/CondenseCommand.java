package fr.kalipso.valorsky.manager.condense.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class CondenseCommand extends ICommand {
    @Command(name="condense", permissionNode = "essentials.condense")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getCondenseModule().condense(args.getPlayer());
    }
}
