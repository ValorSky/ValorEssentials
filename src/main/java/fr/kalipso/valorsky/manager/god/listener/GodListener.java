package fr.kalipso.valorsky.manager.god.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodListener extends Manager implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event)
    {
        this.getInstance().getManager().getGodModule().removeDamage(event);
    }
}
