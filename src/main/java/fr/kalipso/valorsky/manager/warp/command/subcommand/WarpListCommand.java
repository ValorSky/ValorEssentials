package fr.kalipso.valorsky.manager.warp.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class WarpListCommand extends ICommand {
    @Command(name="warp.list", permissionNode = "essentials.warp.list")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getWarpModule().sendList(args.getPlayer());
    }
}
