package fr.kalipso.valorsky.data.command.subcommand;

import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class ProfileSaveCommand extends ICommand {

    private hEssentials instance = hEssentials.getInstance();

    @Command(name="profile.save", permissionNode = "essentials.profile", isConsole = true)
    public void onCommand(CommandArgs args) throws IOException {
        this.instance.getManager().getDataManager().saveAll();
    }
}
