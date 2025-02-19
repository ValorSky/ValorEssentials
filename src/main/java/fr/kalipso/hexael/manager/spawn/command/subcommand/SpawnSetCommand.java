package fr.kalipso.hexael.manager.spawn.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class SpawnSetCommand extends ICommand {

    @Command(name= {"spawn.set", "setspawn"}, permissionNode = "essentials.spawn.set")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getSpawnModule().setSpawn(args.getPlayer(), args.getPlayer().getLocation());
    }
}
