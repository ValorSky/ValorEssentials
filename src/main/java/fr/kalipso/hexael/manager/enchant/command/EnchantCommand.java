package fr.kalipso.hexael.manager.enchant.command;


import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class EnchantCommand extends ICommand {


    @Command(name={"enchant", "enchantment"}, permissionNode = "essentials.enchant")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getEnchantModule().enchantItem(args.getSender(), args.getArgs(0), args.getArgs(1));
    }
}
