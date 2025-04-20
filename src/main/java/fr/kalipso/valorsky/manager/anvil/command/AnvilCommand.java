package fr.kalipso.valorsky.manager.anvil.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class AnvilCommand extends ICommand {

    @Command(name="anvil", permissionNode = "essentials.anvil")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getAnvilModule().openAnvil(args.getPlayer());
    }
}
