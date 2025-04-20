package fr.kalipso.valorsky.manager.privatemessage.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class IgnoreCommand extends ICommand {
    @Command(name="ignore")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getPrivateMessageManager().ignorePlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }
}
