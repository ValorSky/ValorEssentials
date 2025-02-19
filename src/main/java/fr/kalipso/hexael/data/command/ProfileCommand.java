package fr.kalipso.hexael.data.command;

import fr.kalipso.hexael.utils.command.CommandArgs;
import fr.kalipso.hexael.utils.command.ICommand;
import fr.kalipso.hexael.utils.command.annotations.Command;

import java.io.IOException;

public class ProfileCommand extends ICommand {

    @Command(name="profile", permissionNode = "essentials.profile")
    public void onCommand(CommandArgs args) throws IOException {
        args.getSender().sendMessage("§7§m-----------------------");
        args.getSender().sendMessage("");
        args.getSender().sendMessage("§3/profile §7- §fAffiche l'aide des §bprofiles§f.");
        args.getSender().sendMessage("§3/profile save §7- §bSauvegarde§f les §3profiles§f.");
        args.getSender().sendMessage("");
        args.getSender().sendMessage("§7§m-----------------------");
    }
}
