package fr.kalipso.hexael.manager.teleport.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class TeleportCoordsCommand extends ICommand {
    @Command(name={"tpcoords", "teleportcoords"}, permissionNode = "essentials.tpcoords")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 3)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /tpcoords <x> <y> <z>");
            return;
        }
        this.getInstance().getManager().getTeleportModule().teleportToCoords(args.getPlayer(), Integer.valueOf(args.getArgs(0)), Integer.valueOf(args.getArgs(1)), Integer.valueOf(args.getArgs(2)));
    }
}
