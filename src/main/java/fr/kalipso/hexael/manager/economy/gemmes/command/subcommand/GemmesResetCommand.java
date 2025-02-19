package fr.kalipso.hexael.manager.economy.gemmes.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class GemmesResetCommand extends ICommand {
    @Command(name = {"gemmes.reset", "gemme.reset"}, permissionNode = "valorcore.gemmes", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 2)
        {
            args.getSender().sendMessage("§cSyntaxe: /gemmes reset <player>");
            return;
        }
        this.getInstance().getManager().getGemmesManager().resetGemmes(args.getSender(), Bukkit.getPlayer(args.getArgs(0)));
    }
}