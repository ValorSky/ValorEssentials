package fr.kalipso.valorsky.manager.nick;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class NickModule extends Manager {

    private HashMap<Player, String> nickOldName = new HashMap<Player, String>();

    public void setNick(Player sender, String newName)
    {
        nickOldName.put(sender, sender.getName());
        sender.setDisplayName(newName);
        sender.sendMessage(MessageUtils.sendMessage("nick-change").replace("%name%", newName));
    }

    public void removeNick(Player sender)
    {
        if(!nickOldName.containsKey(sender))
        {
            sender.sendMessage(MessageUtils.sendError("nick-no-have"));
            return;
        }
        sender.setDisplayName(nickOldName.get(sender));
        sender.sendMessage(MessageUtils.sendMessage("nick-remove"));
    }
}
