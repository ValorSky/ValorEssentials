package fr.kalipso.valorsky.data.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

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

    @Command(name="profile.resetPlayTime", permissionNode = "essentials.profile")
    public void onCommandd(CommandArgs args) throws IOException {
        this.getInstance().getManager().getDataManager().getProfilePlayer().getProvider().getProfiles().forEach(player -> {
            player.setPlayTime(0);
        });
    }
}
