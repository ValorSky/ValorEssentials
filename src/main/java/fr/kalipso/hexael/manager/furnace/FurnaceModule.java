package fr.kalipso.hexael.manager.furnace;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class FurnaceModule extends Manager {

    public void openFurnace(Player sender)
    {
        sender.openInventory(Bukkit.createInventory(null, InventoryType.FURNACE));
    }
}
