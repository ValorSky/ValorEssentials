package fr.kalipso.valorsky.manager.speed;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

public class SpeedModule extends Manager {

    public void setSpeed(Player sender, float value)
    {
        sender.setFlySpeed(value);
        sender.setWalkSpeed(value);
        sender.sendMessage(MessageUtils.sendMessage("speed-change").replace("%value%", String.valueOf(value)));
    }
}
