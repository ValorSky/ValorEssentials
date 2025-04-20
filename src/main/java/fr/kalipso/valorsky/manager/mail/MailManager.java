package fr.kalipso.valorsky.manager.mail;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.mail.factory.Mail;
import fr.kalipso.valorsky.manager.mail.inventory.MailInventory;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.Utils;
import fr.kalipso.valorsky.utils.item.Base64ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class MailManager extends Manager {

    public void sendTestMail(Player sender, String targetName, ItemStack itemStack)
    {
        Player target = Bukkit.getPlayer(targetName);
        getProfilePlayer(target).getMails().add(new Mail(UUID.randomUUID(), Base64ItemStack.encode(itemStack)));
        sender.sendMessage("test ok");
    }

    public void sendMail(CommandSender sender, String targetName, ItemStack itemStack)
    {
        Player target = Bukkit.getPlayer(targetName);
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        getProfilePlayer(target).getMails().add(new Mail(UUID.randomUUID(), Base64ItemStack.encode(itemStack)));
        target.sendMessage(MessageUtils.sendMessage("mail-receive"));
    }

    public void takeMail(Player player, UUID uuid)
    {
        ItemStack itemStack = Base64ItemStack.decode(getMailById(getProfilePlayer(player), uuid).getContents());
        if(Utils.isInventoryFull(player))
        {
            player.sendMessage(MessageUtils.sendError("inventory-full"));
            return;
        }
        player.getInventory().addItem(itemStack);
        player.sendMessage(MessageUtils.sendMessage("mail-take"));
        this.removeMail(player, getMailById(getProfilePlayer(player), uuid));
    }


    public void removeMail(Player player, Mail mail)
    {
        getProfilePlayer(player).getMails().add(mail);
    }

    public void openMail(Player player)
    {
        if(this.getProfilePlayer(player).getMails().isEmpty())
        {
            player.sendMessage(MessageUtils.sendError("mail-no-have"));
            return;
        }
        MailInventory.getInventory(player).open(player);
    }

    public ProfilePlayer getProfilePlayer(Player player)
    {
        return this.getInstance().getManager().getDataManager().getPlayer(player);
    }

    public Mail getMailById(ProfilePlayer profilePlayer, UUID id)
    {
        AtomicReference<Mail> mail = new AtomicReference<>();
        profilePlayer.getMails().forEach(m -> {
            if(m.getId().equals(id))
            {
                mail.set(m);
            }
        });
        return mail.get();
    }
}
