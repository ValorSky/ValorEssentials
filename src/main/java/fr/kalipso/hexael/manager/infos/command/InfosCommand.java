package fr.kalipso.hexael.manager.infos.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class InfosCommand extends ICommand {
    @Command(name="site")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getInfosModule().sendSite(args.getPlayer());
    }

    @Command(name="infos")
    public void onCommandd(CommandArgs args) throws IOException {
        this.getInstance().getManager().getInfosModule().sendShop(args.getPlayer());
    }
}
