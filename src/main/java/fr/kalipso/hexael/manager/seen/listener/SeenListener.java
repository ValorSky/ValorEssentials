package fr.kalipso.hexael.manager.seen.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SeenListener extends Manager implements Listener {

    @EventHandler
    public void onQuit(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getSeenModule().setLastSeen(event.getPlayer());
    }
}
