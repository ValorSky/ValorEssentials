package fr.kalipso.hexael.manager.motd;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.entity.Player;

public class MotdModule extends Manager {

    public void sendMotd(Player sender)
    {
        this.getInstance().getManager().getConfigManager().get("motd").getStringList("motd").forEach(line -> {
            sender.sendMessage(line.replace("&", "§"));
        });
    }
}
