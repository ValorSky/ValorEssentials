package fr.kalipso.valorsky.manager.furnace.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class FurnaceCommand extends ICommand {
    @Command(name="furnace", permissionNode = "essentials.furnace")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getFurnaceModule().openFurnace(args.getPlayer());
    }
}
