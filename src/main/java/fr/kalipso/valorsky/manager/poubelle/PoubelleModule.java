package fr.kalipso.valorsky.manager.poubelle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PoubelleModule {

    public void openTrash(Player sender)
    {
        sender.openInventory(Bukkit.createInventory(null, 54, ""));
    }
}
