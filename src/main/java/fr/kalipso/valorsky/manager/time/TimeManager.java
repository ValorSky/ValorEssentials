package fr.kalipso.valorsky.manager.time;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

public class TimeManager extends Manager {

    public void setDay(Player player)
    {
        player.getWorld().setTime(0);
        player.sendMessage(MessageUtils.sendMessage("time-set-day"));
    }

    public void setNight(Player player)
    {
        player.getWorld().setTime(1000000);
        player.sendMessage(MessageUtils.sendMessage("time-set-night"));

    }
}
