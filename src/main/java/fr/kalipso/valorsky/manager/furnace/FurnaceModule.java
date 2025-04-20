package fr.kalipso.valorsky.manager.furnace;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class FurnaceModule extends Manager {

    public void openFurnace(Player sender)
    {
        sender.openInventory(Bukkit.createInventory(null, InventoryType.FURNACE));
    }
}
