package fr.kalipso.hexael.manager.enderchest;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.entity.Player;

public class EnderchestModule extends Manager {

    public void openEnderchest(Player sender)
    {
        sender.openInventory(sender.getEnderChest());
    }

    public void openEnderchestOther(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        sender.openInventory(target.getEnderChest());
    }
}
