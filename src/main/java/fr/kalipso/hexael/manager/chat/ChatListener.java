package fr.kalipso.hexael.manager.chat;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

public class ChatListener extends Manager implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        if(event.getMessage().contains("[i]")) {
            if (event.getPlayer().hasPermission("essentials.items")) {
                if (event.getPlayer().getInventory().getItemInMainHand() != null || !event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
                    if (itemStack.getItemMeta().hasDisplayName()) {
                        event.setMessage(event.getMessage().replace("[i]", "§a" + itemStack.getItemMeta().getDisplayName()));
                    }
                    else
                    {
                        event.setMessage(event.getMessage().replace("[i]", "§a" + itemStack.getType().toString()));
                    }
                }
            }
        }
    }
}
