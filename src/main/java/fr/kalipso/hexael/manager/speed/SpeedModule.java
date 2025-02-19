package fr.kalipso.hexael.manager.speed;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.entity.Player;

public class SpeedModule extends Manager {

    public void setSpeed(Player sender, float value)
    {
        sender.setFlySpeed(value);
        sender.setWalkSpeed(value);
        sender.sendMessage(MessageUtils.sendMessage("speed-change").replace("%value%", String.valueOf(value)));
    }
}
