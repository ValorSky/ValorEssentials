package fr.kalipso.valorsky.manager.motd;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.entity.Player;

public class MotdModule extends Manager {

    public void sendMotd(Player sender)
    {
        this.getInstance().getManager().getConfigManager().get("motd").getStringList("motd").forEach(line -> {
            sender.sendMessage(line.replace("&", "§"));
        });
    }
}
