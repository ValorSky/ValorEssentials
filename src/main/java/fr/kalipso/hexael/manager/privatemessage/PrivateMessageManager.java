package fr.kalipso.hexael.manager.privatemessage;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.privatemessage.command.PrivateMessageCommand;
import fr.kalipso.hexael.manager.privatemessage.factory.PrivateMessage;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrivateMessageManager extends Manager {

    private HashMap<Player, PrivateMessage> privateMessage = new HashMap<>();
    private HashMap<Player, List<Player>> ignoreList = new HashMap<>();
    //vider l'ignore list a la déco

    public void createIgnoreList(Player sender)
    {
        if(!ignoreList.containsKey(sender))
        {
            ignoreList.put(sender, new ArrayList<>());
        }
    }

    public void sendPM(Player sender, Player target, String message)
    {
        /**if(sender == target)
        {
            sender.sendMessage(MessageUtils.sendError("private-cant-him"));
            return;
        }**/
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(ignoreList.get(sender).contains(target) || ignoreList.get(target).contains(sender))
        {
            sender.sendMessage(MessageUtils.sendMessage("private-ignored"));
            return;
        }
        privateMessage.put(target, new PrivateMessage(sender, target, message));
        sender.sendMessage(MessageUtils.sendMessage("private-to").replace("%target%", target.getName()).replace("%message%", message));
        target.sendMessage(MessageUtils.sendMessage("private-from").replace("%sender%", sender.getName()).replace("%message%", message));

    }

    public void replyPM(Player sender)
    {
        if(!privateMessage.containsKey(sender))
        {
            sender.sendMessage(MessageUtils.sendError("private-dont-have"));
            return;
        }
        PrivateMessage pm = this.privateMessage.get(sender);
        if(pm.getSender() == null || Bukkit.getPlayer(pm.getSender().getUniqueId()) == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        Player target = pm.getSender();
        if(ignoreList.get(sender).contains(target) || ignoreList.get(target).contains(sender))
        {
            sender.sendMessage(MessageUtils.sendMessage("private-ignored"));
            return;
        }
        sender.sendMessage(MessageUtils.sendMessage("private-to").replace("%target%", target.getName()).replace("%message%", pm.getMessage()));
        target.sendMessage(MessageUtils.sendMessage("private-from").replace("%sender%", sender.getName()).replace("%message%", pm.getMessage()));
        this.privateMessage.remove(sender);
    }

    public void ignorePlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(sender == target)
        {
            sender.sendMessage(MessageUtils.sendError("private-ignore-cant-him"));
            return;
        }
        if(!ignoreList.containsKey(sender))
        {
            List<Player> ignored = new ArrayList<>();
            ignored.add(target);
            this.ignoreList.put(sender, ignored);
        }
        else
        {
            this.ignoreList.get(sender).add(target);
        }
    }

    public void removeIgnoreList(Player sender)
    {
        if(ignoreList.containsKey(sender))
        {
            ignoreList.remove(sender);
        }
    }
}
