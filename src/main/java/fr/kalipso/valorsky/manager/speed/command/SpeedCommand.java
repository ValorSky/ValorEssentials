package fr.kalipso.valorsky.manager.speed.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class SpeedCommand extends ICommand {
    @Command(name={"s", "speed"}, permissionNode = "essentials.speed")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() == 0)
        {
            args.getPlayer().sendMessage("§cSyntaxe: /speed <value>");
            return;
        }
        this.getInstance().getManager().getSpeedModule().setSpeed(args.getPlayer(), Float.valueOf(args.getArgs(0)));
    }
}
