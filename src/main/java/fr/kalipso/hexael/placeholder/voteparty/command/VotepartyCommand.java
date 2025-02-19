package fr.kalipso.hexael.placeholder.voteparty.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class VotepartyCommand extends ICommand {
    @Command(name={"voteparty", "vp"})
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getVotepartyModule().showVoteparty(args.getPlayer());
    }
}
