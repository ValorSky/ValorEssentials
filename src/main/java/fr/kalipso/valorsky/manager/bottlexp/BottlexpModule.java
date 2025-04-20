package fr.kalipso.valorsky.manager.bottlexp;

import de.tr7zw.nbtapi.NBT;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BottlexpModule extends Manager {

    public void setInBottle(Player sender)
    {
        if(sender.getLevel() < 1)
        {
            sender.sendMessage(MessageUtils.sendError("bottlexp-no-level"));
            return;
        }
        float exp = sender.getExp();
        int level = sender.getExpToLevel();
        List<String> lore = new ArrayList<>();
        this.getInstance().getManager().getConfigManager().get("main").getStringList("bottlexp-lore").forEach(line -> {
            lore.add(line.replace("%level%", String.valueOf(level))
                    .replace("%exp%", String.valueOf(exp)));
        });
        ItemBuilder bottle = new ItemBuilder(Material.EXPERIENCE_BOTTLE)
                .setName(this.getInstance().getManager().getConfigManager().get("main").getString("bottlexp-name").replace("%level%", String.valueOf(level)))
                .setLore(lore);
        ItemStack itemStack = bottle.toItemStack();
        NBT.modify(itemStack, nbt -> {
            nbt.setInteger("level", level);
        });
        sender.getInventory().addItem(itemStack);
        sender.sendMessage(MessageUtils.sendMessage("bottlexp-add").replace("%level%", String.valueOf(level)));
    }

    public void giveExp(PlayerInteractEvent event, Player sender, ItemStack item)
    {
        if(item == null || item.getType() != Material.EXPERIENCE_BOTTLE) return;
        NBT.get(item, nbt -> {
            if(!nbt.hasTag("level")) return;
            int level = nbt.getInteger("level");
            sender.setLevel(sender.getLevel() + level);
            sender.sendMessage(MessageUtils.sendMessage("bottlexp-add-level").replace("%level%", String.valueOf(level)));
            event.setCancelled(true);
        });

    }
}
