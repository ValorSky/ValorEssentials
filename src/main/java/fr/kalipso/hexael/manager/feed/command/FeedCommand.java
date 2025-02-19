package fr.kalipso.hexael.manager.feed.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class FeedCommand extends ICommand {
    @Command(name="feed", permissionNode = "essentials.feed")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getFeedModule().feedPlayer(args.getPlayer());
        }
        else if(args.length() == 1)
        {
            if(args.getArgs(0).equalsIgnoreCase("on") || args.getArgs(0).equalsIgnoreCase("off"))
            {
                this.getInstance().getManager().getFeedModule().setAutofeed(args.getPlayer());
            }
            else
            {
                this.getInstance().getManager().getFeedModule().feedPlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
            }
        }
    }
}
