package fr.kalipso.hexael.manager.teleport.command.subcommand;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class TeleportDenyCommand extends ICommand {
    @Command(name={"tpdeny", "tpnon", "tpno"}, permissionNode = "essentials.tpdeny")
    public void onCommand(CommandArgs args) throws IOException {
        this.getInstance().getManager().getTeleportModule().denyTeleportRequest(args.getPlayer());
    }
}
