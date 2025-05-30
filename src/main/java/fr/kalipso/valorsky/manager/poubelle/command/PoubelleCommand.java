package fr.kalipso.valorsky.manager.poubelle.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class PoubelleCommand extends ICommand {
    @Command(name={"poubelle", "trash", "bin"}, permissionNode = "essentials.poubelle")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getPoubelleModule().openTrash(args.getPlayer());
    }
}
