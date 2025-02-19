package fr.kalipso.hexael.manager.warp.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class WarpDeleteCommand extends ICommand {
    @Command(name="warp.delete", permissionNode = "essentials.warp.delete")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /warp delete <nom>");
            return;
        }
        this.getInstance().getManager().getWarpModule().deleteWarp(args.getPlayer(), args.getArgs(0));
    }
}
