package fr.kalipso.valorsky.manager.anvil;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class AnvilModule extends Manager {

    public void openAnvil(Player sender)
    {
        sender.openInventory(Bukkit.createInventory(null, InventoryType.ANVIL));
    }
}
