package fr.kalipso.valorsky.manager.hat;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatModule extends Manager {

    public void setHat(Player sender, ItemStack item)
    {
        if(item.getType() == Material.AIR || item == null)
        {
            sender.sendMessage(MessageUtils.sendError("hat-cant"));
            return;
        }
        ItemStack helmet = sender.getInventory().getHelmet();
        sender.getInventory().setHelmet(item);
        sender.getInventory().addItem(helmet);
        sender.sendMessage(MessageUtils.sendMessage("hat-set"));
    }
}
