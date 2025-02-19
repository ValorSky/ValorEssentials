package fr.kalipso.hexael.manager.repair.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class RepairCommand extends ICommand {


    @Command(name="repair", permissionNode = "essentials.repair")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getRepairModule().showHelp(args.getPlayer());
    }
}
