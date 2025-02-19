package fr.kalipso.hexael.manager.economy.gemmes.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class GemmesCommand extends ICommand {
    @Command(name= {"gemmes", "gemme"}, permissionNode = "valorcore.gemmes", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getGemmesManager().showHelp(args.getSender());
    }
}
