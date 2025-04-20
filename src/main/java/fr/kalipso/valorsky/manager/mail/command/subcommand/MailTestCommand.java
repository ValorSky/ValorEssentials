package fr.kalipso.valorsky.manager.mail.command.subcommand;

import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;

import java.io.IOException;

public class MailTestCommand extends ICommand {
    @Command(name="mail.test", permissionNode = "essentials.mail.admin")
    public void onCommand(CommandArgs args) throws IOException {
        if(args.length() != 1)
        {
            args.getSender().sendMessage("§cSyntaxe: /mail test <player>");
            return;
        }
        getInstance().getManager().getMailManager().sendTestMail(args.getPlayer(), args.getArgs(0), args.getPlayer().getInventory().getItemInMainHand());
    }
}
