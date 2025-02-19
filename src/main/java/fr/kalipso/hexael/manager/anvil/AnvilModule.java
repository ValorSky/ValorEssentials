package fr.kalipso.hexael.manager.anvil;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class AnvilModule extends Manager {

    public void openAnvil(Player sender)
    {
        sender.openInventory(Bukkit.createInventory(null, InventoryType.ANVIL));
    }
}
