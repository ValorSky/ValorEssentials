package fr.kalipso.hexael.manager.spawn.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class SpawnCommand extends ICommand {


    @Command(name="spawn", permissionNode = "esssentials.spawn", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 1)
        {
            this.getInstance().getManager().getSpawnModule().teleportSpawn(args.getSender(), Bukkit.getPlayer(args.getArgs(0)));
            return;
        }
        this.getInstance().getManager().getSpawnModule().teleportSpawn(args.getPlayer());
    }
}
