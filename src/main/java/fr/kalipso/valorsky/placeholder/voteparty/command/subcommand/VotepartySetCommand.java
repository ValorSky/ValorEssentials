package fr.kalipso.valorsky.placeholder.voteparty.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class VotepartySetCommand extends ICommand {
    @Command(name={"voteparty.setmax", "vp.setmax"}, permissionNode = "valorcore.voteparty")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /voteparty setmax <value>");
            return;
        }
        this.getInstance().getManager().getVotepartyModule().setVotepartyMax(args.getPlayer(), args.getArgs(0));
    }
}
