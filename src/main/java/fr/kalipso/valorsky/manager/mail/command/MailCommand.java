package fr.kalipso.valorsky.manager.mail.command;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class MailCommand extends ICommand {
    @Command(name="mail", permissionNode = "essentials.mail")
    public void onCommand(CommandArgs args) throws IOException {
        getInstance().getManager().getMailManager().openMail(args.getPlayer());
    }
}
