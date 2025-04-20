package fr.kalipso.valorsky.manager.bottlexp.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class BottlexpCommand extends ICommand {

    @Command(name="bottlexp", permissionNode = "essentials.bottlexp")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getBottlexpModule().setInBottle(args.getPlayer());
    }
}
