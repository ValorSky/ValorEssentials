package fr.kalipso.hexael.manager.heal.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class HealCommand extends ICommand {
    @Command(name="heal", permissionNode = "essentials.heal")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getHealModule().healPlayer(args.getPlayer());
        }
        else
        {
            this.getInstance().getManager().getHealModule().healPlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
        }
    }
}
