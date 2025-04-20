package fr.kalipso.valorsky.manager.repair.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class RepairAllCommand extends ICommand {
    @Command(name="repair.all", permissionNode = "essentials.repair.all")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getRepairModule().repairAll(args.getPlayer());
    }
}
