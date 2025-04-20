package fr.kalipso.valorsky.manager.kits.commands.subcommand;


import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

public class KitsPreviewCommand extends ICommand {

    @Command(name={"kit.preview", "kits.preview"}, permissionNode = "essentials.kits")
    public void onCommand(CommandArgs args)
    {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /kit preview <nom>");
            return;
        }
        this.getInstance().getManager().getKitsModule().showPreviewKit(args.getPlayer(), args.getArgs(0));

    }
}
