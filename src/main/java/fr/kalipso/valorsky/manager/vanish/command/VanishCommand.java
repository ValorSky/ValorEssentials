package fr.kalipso.valorsky.manager.vanish.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class VanishCommand extends ICommand {
    @Command(name={"vanish", "v"}, permissionNode = "essentials.vanish")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getVanishModule().setVanishPlayer(args.getPlayer());
    }
}
