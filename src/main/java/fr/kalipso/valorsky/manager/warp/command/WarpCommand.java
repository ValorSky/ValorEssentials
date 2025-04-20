package fr.kalipso.valorsky.manager.warp.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class WarpCommand extends ICommand {
    @Command(name="warp", permissionNode = "essentials.warp", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 1)
        {
            this.getInstance().getManager().getWarpModule().teleportWarp(args.getPlayer(), args.getArgs(0));
            return;
        }
        else if(args.length() == 2)
        {
            this.getInstance().getManager().getWarpModule().teleportWarpPlayer(Bukkit.getPlayer(args.getArgs(1)), args.getSender(), args.getArgs(0));
            return;
        }
        this.getInstance().getManager().getWarpModule().sendHelp(args.getPlayer());
    }
}
