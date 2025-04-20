package fr.kalipso.valorsky.manager.infos.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

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
