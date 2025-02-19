package fr.kalipso.hexael.manager.kits.commands.subcommand;


import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class KitsDeleteCommand extends ICommand {

    @Command(name={"kit.delete", "kits.delete"}, permissionNode = "essentials.kits.delete")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /kit delete <nom>");
            return;
        }
        this.getInstance().getManager().getKitsModule().removeKit(args.getPlayer(), args.getArgs(0));

    }
}
