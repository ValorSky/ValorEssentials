package fr.kalipso.valorsky.manager.back.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BackListener extends Manager implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event)
    {
        this.getInstance().getManager().getBackModule().addPreviousLoc(event.getPlayer(), event.getFrom());
    }
}
