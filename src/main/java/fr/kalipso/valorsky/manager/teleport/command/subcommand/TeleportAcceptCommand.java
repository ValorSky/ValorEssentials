package fr.kalipso.valorsky.manager.teleport.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class TeleportAcceptCommand extends ICommand {
    @Command(name={"tpyes", "tpaccept", "tpoui"}, permissionNode = "essentials.tpaccept")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getTeleportModule().acceptTeleportRequest(args.getPlayer());
    }
}
