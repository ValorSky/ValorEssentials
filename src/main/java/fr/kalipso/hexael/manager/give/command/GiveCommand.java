package fr.kalipso.hexael.manager.give.command;


import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class GiveCommand extends ICommand {


    @Command(name="give", permissionNode = "essentials.give.other")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getGiveModule().giveItem(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)), args);
    }

    @Command(name="i", permissionNode = "essentials.give")
    public void onCommand2(CommandArgs args) throws IOException {
        this.getInstance().getManager().getGiveModule().giveItem(args.getPlayer(), args);
    }
}
