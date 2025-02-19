package fr.kalipso.hexael.manager.fly.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class FlyCommand extends ICommand {


    @Command(name = {"fly", "tempfly", "tf"}, permissionNode = "essentials.fly", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 0 && args.length() != 3)
        {
            args.getSender().sendMessage("§cSyntaxe /fly [add <player> <time>]");
        }
        else if(args.length() == 0)
        {
            this.getInstance().getManager().getFlyModule().flyPlayer(args.getPlayer());
        }
        else if (args.length() == 3 && args.getArgs(0).equalsIgnoreCase("add"))
        {
            this.getInstance().getManager().getFlyModule().addTempFly(args.getSender(), Bukkit.getPlayer(args.getArgs(1)), args.getArgs(2));
        }
    }
}
