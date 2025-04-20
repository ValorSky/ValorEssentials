package fr.kalipso.valorsky.manager.repair;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RepairModule extends Manager {

    public void repairHand(Player sender)
    {
        ItemStack item = sender.getInventory().getItemInMainHand();
        if(item == null || item.getType() == Material.AIR || !Utils.isRepairable(item.getType()))
        {
            sender.sendMessage(MessageUtils.sendError("repair-no-item"));
            return;
        }
        item.setDurability((short)0);
        sender.sendMessage(MessageUtils.sendMessage("repair-hand"));
    }

    public void repairAll(Player sender)
    {
        ItemStack[] contents = sender.getInventory().getContents();
        for(ItemStack item : contents)
        {
            if(item == null || item.getType() == Material.AIR || !Utils.isRepairable(item.getType()))
            {
                sender.sendMessage(MessageUtils.sendError("repair-no-item"));
                return;
            }
            item.setDurability((short)0);
        }
        sender.sendMessage(MessageUtils.sendMessage("repair-all"));
    }

    public void showHelp(Player sender)
    {
        sender.sendMessage("§7§m-------§f§m-------§7§m-------");
        sender.sendMessage("");
        sender.sendMessage("§f/repair §7- §bAffiche l'aide du Repair.");
        sender.sendMessage("§f/repair hand §7- §bRépare ton item en main.");
        sender.sendMessage("§f/repair all §7- §bRépare tes items en inventaires.");
        sender.sendMessage("");
        sender.sendMessage("§7§m-------§f§m-------§7§m-------");
    }
}
