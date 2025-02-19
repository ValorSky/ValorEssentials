package fr.kalipso.hexael.manager.enderchest.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class EnderchestCommand extends ICommand {
    @Command(name={"enderchest", "echest", "ec"}, permissionNode = "essentials.enderchest")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getEnderchestModule().openEnderchest(args.getPlayer());
        }
        else
        {
            this.getInstance().getManager().getEnderchestModule().openEnderchestOther(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
        }
    }
}
