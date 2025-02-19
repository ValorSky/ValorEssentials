package fr.kalipso.hexael.manager.repair.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class RepairHandCommand extends ICommand {
    @Command(name="repair.hand", permissionNode = "essentials.repair.hand")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getRepairModule().repairHand(args.getPlayer());
    }
}
