package fr.kalipso.valorsky.manager.craft.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class CraftCommand extends ICommand {

    @Command(name={"craft", "workbench"}, permissionNode = "essentials.craft")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getCraftModule().openWorkbench(args.getPlayer());
    }
}
