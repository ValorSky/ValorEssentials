package fr.kalipso.hexael.placeholder.voteparty.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class VotepartyAddCommand extends ICommand {
    @Command(name={"voteparty.add", "vp.add"}, permissionNode = "valorcore.voteparty", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getVotepartyModule().addVoteParty(args.getSender());
    }
}
