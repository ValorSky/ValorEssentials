package fr.kalipso.hexael.manager.nick.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class NickCommand extends ICommand {
    @Command(name="nick", permissionNode = "essentials.nick")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() !=1 )
        {
            args.getPlayer().sendMessage("§cSyntaxe: /nick <newName>");
            return;
        }
        this.getInstance().getManager().getNickModule().setNick(args.getPlayer(), args.getArgs(0));
    }
}
