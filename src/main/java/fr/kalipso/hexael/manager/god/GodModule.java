package fr.kalipso.hexael.manager.god;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class GodModule extends Manager {

    private List<Player> god = new ArrayList<>();

    public void setGod(Player sender)
    {
        if(god.contains(sender))
        {
            god.remove(sender);
            sender.sendMessage(MessageUtils.sendMessage("god-unset"));
        }
        else
        {
            god.add(sender);
            sender.sendMessage(MessageUtils.sendMessage("god-set"));
        }
    }

    public void setGod(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(god.contains(target))
        {
            god.remove(target);
            target.sendMessage(MessageUtils.sendMessage("god-unset"));
            sender.sendMessage(MessageUtils.sendMessage("god-unset-other").replace("%target%", target.getName()));
        }
        else
        {
            god.add(sender);
            target.sendMessage(MessageUtils.sendMessage("god-set"));
            sender.sendMessage(MessageUtils.sendMessage("god-set-other").replace("%target%", target.getName()));
        }
    }

    public void removeDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            if(god.contains(event.getEntity()))
            {
                event.setCancelled(true);
            }
        }
    }
}
