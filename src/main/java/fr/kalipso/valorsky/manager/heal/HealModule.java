package fr.kalipso.valorsky.manager.heal;

import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

public class HealModule {

    public void healPlayer(Player sender)
    {
        sender.setHealth(20);
        sender.sendMessage(MessageUtils.sendMessage("heal"));
    }

    public void healPlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        target.setHealth(20);
        sender.sendMessage(MessageUtils.sendMessage("heal-other").replace("%target%", target.getName()));
        target.sendMessage(MessageUtils.sendMessage("heal"));
    }
}
