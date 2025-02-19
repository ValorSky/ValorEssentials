package fr.kalipso.hexael.manager.craft.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class CraftCommand extends ICommand {

    @Command(name={"craft", "workbench"}, permissionNode = "essentials.craft")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getCraftModule().openWorkbench(args.getPlayer());
    }
}
