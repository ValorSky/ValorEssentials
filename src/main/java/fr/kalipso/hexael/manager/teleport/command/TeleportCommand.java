package fr.kalipso.hexael.manager.teleport.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class TeleportCommand extends ICommand {
    @Command(name={"tp", "teleport"}, permissionNode = "essentials.tp")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getTeleportModule().showHelp(args.getPlayer());
            return;
        }
        this.getInstance().getManager().getTeleportModule().teleportToPlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }
}
