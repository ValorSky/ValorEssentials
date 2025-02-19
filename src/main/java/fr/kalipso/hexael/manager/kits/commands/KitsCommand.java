package fr.kalipso.hexael.manager.kits.commands;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

public class KitsCommand extends ICommand {

    @Command(name={"kit", "kits"}, permissionNode = "essentials.kits")
    public void onCommand(CommandArgs args)
    {
        if(args.length() == 0)
        {
            this.getInstance().getManager().getKitsModule().showListKit(args.getPlayer());
            return;
        }
        if(args.length() == 1)
        {
            this.getInstance().getManager().getKitsModule().giveKit(args.getPlayer(), args.getArgs(0));
        }
        if(args.length() == 2)
        {
            this.getInstance().getManager().getKitsModule().giveKit(args.getPlayer(), Bukkit.getPlayer(args.getArgs(1)), args.getArgs(0));
        }
    }
}
