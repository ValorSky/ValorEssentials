package fr.kalipso.valorsky.manager.kits.commands.subcommand;


import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

public class KitsCreateCommand extends ICommand {

    @Command(name={"kit.create", "kits.create"}, permissionNode = "essentials.kits.create")
    public void onCommand(CommandArgs args)
    {
        if(args.length() != 2)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /kit create <nom> <delai>");
            return;
        }
        this.getInstance().getManager().getKitsModule().createKit(args.getPlayer(), args.getArgs(0), Integer.parseInt(args.getArgs(1)));

    }
}
