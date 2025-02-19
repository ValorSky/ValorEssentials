package fr.kalipso.hexael.manager.furnace.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class FurnaceCommand extends ICommand {
    @Command(name="furnace", permissionNode = "essentials.furnace")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getFurnaceModule().openFurnace(args.getPlayer());
    }
}
