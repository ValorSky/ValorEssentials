package fr.kalipso.hexael.manager.warp.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class WarpListCommand extends ICommand {
    @Command(name="warp.list", permissionNode = "essentials.warp.list")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getWarpModule().sendList(args.getPlayer());
    }
}
