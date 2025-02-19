package fr.kalipso.hexael.manager.privatemessage.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class IgnoreCommand extends ICommand {
    @Command(name="ignore")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getPrivateMessageManager().ignorePlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }
}
