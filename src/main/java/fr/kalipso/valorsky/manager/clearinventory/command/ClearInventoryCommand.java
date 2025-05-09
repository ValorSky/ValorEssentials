package fr.kalipso.valorsky.manager.clearinventory.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class ClearInventoryCommand extends ICommand {
    @Command(name={"clearinventory", "clearinv", "ci"}, permissionNode = "core.clearinv")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getClearInventoryModule().clearInventory(args.getPlayer());
        }
        else
        {
            this.getInstance().getManager().getClearInventoryModule().clearInventory(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
        }
    }
}
