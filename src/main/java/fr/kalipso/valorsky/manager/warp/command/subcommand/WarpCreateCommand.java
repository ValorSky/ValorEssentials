package fr.kalipso.valorsky.manager.warp.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class WarpCreateCommand extends ICommand {
    @Command(name="warp.create", permissionNode = "essentials.warp.create")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /warp create <nom>");
            return;
        }
        this.getInstance().getManager().getWarpModule().createWarp(args.getPlayer(), args.getArgs(0));
    }
}
