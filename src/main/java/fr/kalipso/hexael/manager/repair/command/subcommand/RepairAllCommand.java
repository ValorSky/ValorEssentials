package fr.kalipso.hexael.manager.repair.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class RepairAllCommand extends ICommand {
    @Command(name="repair.all", permissionNode = "essentials.repair.all")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getRepairModule().repairAll(args.getPlayer());
    }
}
