package fr.kalipso.hexael.manager.deathmessages.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessagesListener extends Manager implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        this.getInstance().getManager().getDeathMessagesModule().sendMessages(event);
    }
}
