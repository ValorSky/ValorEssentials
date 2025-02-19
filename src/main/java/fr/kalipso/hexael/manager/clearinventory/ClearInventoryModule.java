package fr.kalipso.hexael.manager.clearinventory;

import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.entity.Player;

public class ClearInventoryModule {

    public void clearInventory(Player sender)
    {
        sender.getInventory().clear();
        sender.sendMessage("§aVous venez de vider votre inventaire.");
    }

    public void clearInventory(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        target.getInventory().clear();
        target.sendMessage("§aVous venez de vider votre inventaire.");
        target.sendMessage("§aVous venez de vider l'inventaire de "+ target.getName() + ".");
    }
}
