package fr.kalipso.valorsky.manager.teleport.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class TeleportDenyCommand extends ICommand {
    @Command(name={"tpdeny", "tpnon", "tpno"}, permissionNode = "essentials.tpdeny")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getTeleportModule().denyTeleportRequest(args.getPlayer());
    }
}
