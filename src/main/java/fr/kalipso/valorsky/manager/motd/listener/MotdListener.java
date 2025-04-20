package fr.kalipso.valorsky.manager.motd.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MotdListener extends Manager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getMotdModule().sendMotd(event.getPlayer());
    }
}
