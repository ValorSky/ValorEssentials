package fr.kalipso.valorsky.placeholder.voteparty.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class VotepartyCommand extends ICommand {
    @Command(name={"voteparty", "vp"})
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getVotepartyModule().showVoteparty(args.getPlayer());
    }
}
