package fr.kalipso.valorsky.manager.seen.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class SeenCommand extends ICommand {
    @Command(name="seen", permissionNode = "essentials.seen")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getSeenModule().sendLastSeen(args.getPlayer(), args.getPlayer(), args.getPlayer().getName());
        }
        else
        {
            this.getInstance().getManager().getSeenModule().sendLastSeen(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)), args.getArgs(0));
        }
    }
}
