package fr.kalipso.hexael.manager.spawn.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnListener extends Manager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        if(!event.getPlayer().hasPlayedBefore())
        {
            this.getInstance().getManager().getSpawnModule().teleport(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        this.getInstance().getManager().getSpawnModule().teleport(event.getEntity());
    }
}
