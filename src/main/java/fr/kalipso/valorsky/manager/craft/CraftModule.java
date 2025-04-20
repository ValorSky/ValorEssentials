package fr.kalipso.valorsky.manager.craft;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.entity.Player;

public class CraftModule extends Manager {

    public void openWorkbench(Player sender)
    {
        sender.openWorkbench(sender.getLocation(), true);
    }
}
