package fr.kalipso.valorsky.manager.kits.listener;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.kits.inventory.PreviewHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class KitsInventoryListener extends Manager implements Listener {


    @EventHandler
    public void onMove(InventoryMoveItemEvent e)
    {
        if(e.getInitiator().getHolder() instanceof PreviewHolder)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(InventoryDragEvent e)
    {
        if(e.getInventory().getHolder() instanceof PreviewHolder)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(InventoryPickupItemEvent e)
    {
        if(e.getInventory().getHolder() instanceof PreviewHolder)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if(e.getInventory().getHolder() instanceof PreviewHolder)
        {
            e.setCancelled(true);
        }
    }
}
