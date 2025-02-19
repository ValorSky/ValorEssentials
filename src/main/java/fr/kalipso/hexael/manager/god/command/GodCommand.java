package fr.kalipso.hexael.manager.god.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class GodCommand extends ICommand {


    @Command(name="god", permissionNode = "essentials.god")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getGodModule().setGod(args.getPlayer());
            return;
        }
        else
        {
            this.getInstance().getManager().getGodModule().setGod(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
        }
    }
}
