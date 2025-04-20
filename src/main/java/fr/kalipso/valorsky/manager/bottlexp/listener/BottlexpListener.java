package fr.kalipso.valorsky.manager.bottlexp.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BottlexpListener extends Manager implements Listener {

    @EventHandler
    public void onItemUse(PlayerInteractEvent event)
    {
        this.getInstance().getManager().getBottlexpModule().giveExp(event, event.getPlayer(), event.getItem());
    }
}
