package fr.kalipso.valorsky.manager.condense;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CondenseModule extends Manager {

    public void condense(Player p)
    {
        Inventory i = p.getInventory();
        int coal = 0;
        int iron = 0;
        int gold = 0;
        int diamond = 0;
        int emerald = 0;
        int redstone = 0;
        int bypass = 0;
        int belowMin = 0;

        for (ItemStack item : i.getContents()) {
            if (item == null) continue;
            if (item.getType().equals(Material.AIR)) continue;

            else if (item.getType().equals(Material.COAL)) {
                coal = coal + item.getAmount();
            }
            else if (item.getType().equals(Material.IRON_INGOT)) {
                iron = iron + item.getAmount();
            }
            else if (item.getType().equals(Material.GOLD_INGOT)) {
                gold = gold + item.getAmount();
            }
            else if (item.getType().equals(Material.DIAMOND)) {
                diamond = diamond + item.getAmount();
            }
            else if (item.getType().equals(Material.EMERALD)) {
                emerald = emerald + item.getAmount();
            }
            else if (item.getType().equals(Material.REDSTONE)) {
                redstone = redstone + item.getAmount();
            }
        }

        if (coal==0) bypass+=1;
        else if (coal<9) belowMin+=1;
        else {
            while (coal >= 9) {
                coal = coal-9;
                p.getInventory().removeItem(new ItemStack(Material.COAL, 9));
                p.getInventory().addItem(new ItemStack(Material.COAL_BLOCK, 1));
            }
        }

        if (iron==0) bypass+=1;
        else if (iron<9) belowMin+=1;
        else {
            while (iron >= 9) {
                iron = iron - 9;
                p.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 9));
                p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, 1));
            }
        }

        if (gold==0) bypass+=1;
        else if (gold<9) belowMin+=1;
        else {
            while (gold >= 9) {
                gold = gold - 9;
                p.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 9));
                p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 1));
            }
        }

        if (diamond==0) bypass += 1;
        else if (diamond<9) belowMin+=1;
        else {
            while (diamond >= 9) {
                diamond = diamond - 9;
                p.getInventory().removeItem(new ItemStack(Material.DIAMOND, 9));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 1));
            }
        }

        if (emerald==0) bypass += 1;
        else if (emerald<9) belowMin+=1;
        else {
            while (emerald >= 9) {
                emerald = emerald - 9;
                p.getInventory().removeItem(new ItemStack(Material.EMERALD, 9));
                p.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK, 1));
            }
        }

        if (redstone==0) bypass += 1;
        else if (redstone<9) belowMin+=1;
        else {
            while (redstone >= 9) {
                redstone = redstone - 9;
                p.getInventory().removeItem(new ItemStack(Material.REDSTONE, 9));
                p.getInventory().addItem(new ItemStack(Material.REDSTONE_BLOCK, 1));
            }
        }

        if (belowMin+bypass==4) p.sendMessage(MessageUtils.sendError("condense-cant"));

        p.sendMessage(MessageUtils.sendMessage("condense"));

    }
}
