package fr.kalipso.valorsky.manager.kill.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;

import java.io.IOException;

public class KillCommand extends ICommand {
    @Command(name="kill", permissionNode = "essentials.kill")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /kill <player/all>");
            return;
        }
        this.getInstance().getManager().getKillModule().killPlayer(args.getPlayer(), Bukkit.getPlayer(args.getArgs(0)));
    }

    @Command(name={"killall", "kill.all"}, permissionNode = "essentials.kill")
    public void onCommandd(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /kill <player/all>");
            return;
        }
        this.getInstance().getManager().getKillModule().killEntities(args.getPlayer());
    }
}
