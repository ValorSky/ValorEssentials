package fr.kalipso.valorsky.manager.time.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class TimeNightCommand extends ICommand {
    @Command(name="day", permissionNode = "essentials.time")
    public void onCommand(CommandArgs args) throws IOException {
        getInstance().getManager().getTimeManager().setNight(args.getPlayer());
    }
}
