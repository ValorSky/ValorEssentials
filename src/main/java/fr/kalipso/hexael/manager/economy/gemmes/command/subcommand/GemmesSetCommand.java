package fr.kalipso.hexael.manager.economy.gemmes.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class GemmesSetCommand extends ICommand {
    @Command(name = {"gemmes.set", "gemme.set"}, permissionNode = "valorcore.gemmes", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 2)
        {
            args.getSender().sendMessage("§cSyntaxe: /gemmes set <player> <value>");
            return;
        }
        this.getInstance().getManager().getGemmesManager().setGemmes(args.getSender(), Bukkit.getPlayer(args.getArgs(0)), args.getArgs(1));
    }
}