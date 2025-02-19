package fr.kalipso.hexael.manager.enchant;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.StringUtils;
import fr.kalipso.hexael.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnchantModule extends Manager {

    public void enchantItem(CommandSender sender, String enchName, String level)
    {
        if(enchName == null || level == null)
        {
            sender.sendMessage("§cSyntaxe : /enchant <name> <level>");
            return;
        }
        Enchantment enchantment = Enchantment.getByName(Utils.getEnchantName(enchName.toUpperCase()));
        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item == null || item.getType() == Material.AIR)
        {
            sender.sendMessage(MessageUtils.sendError("enchantment-item-no-valid"));
            return;
        }

        if(!StringUtils.isInteger(level))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        int lvl = Integer.valueOf(level);
        if(lvl > 7 && !sender.isOp())
        {
            sender.sendMessage(MessageUtils.sendError("enchantment-limit-level"));
            return;
        }
        if(enchantment == null)
        {
            sender.sendMessage(MessageUtils.sendError("enchantment-no-exist"));
            return;
        }
        if(lvl == 0)
        {
            item.removeEnchantment(enchantment);
            sender.sendMessage(MessageUtils.sendMessage("enchantment-remove"));
            return;
        }
        item.addUnsafeEnchantment(enchantment, lvl);
        sender.sendMessage(MessageUtils.sendMessage("enchantment-add").replace("%name%", enchName.toUpperCase()));
    }
}
