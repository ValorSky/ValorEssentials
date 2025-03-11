package fr.kalipso.hexael.manager.chat;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.LuckPermsUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

public class ChatManager extends Manager {

    private YamlConfiguration config = this.getInstance().getManager().getConfigManager().get("chat");

    public void sendItem(AsyncPlayerChatEvent event)
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

    public void sendChat(AsyncPlayerChatEvent event)
    {
        if(config.getString(LuckPermsUtils.getRankName(event.getPlayer()) + "-format") == null)
        {
            event.setFormat(config.getString("chat-format").replace("&", "§").replace("{prefix}", LuckPermsUtils.getGroupPrefix("default")).replace("{name}", event.getPlayer().getName()).replace("{message}", event.getMessage()));
            return;
        }
        event.setFormat(config.getString(LuckPermsUtils.getRankName(event.getPlayer()) + "-format").replace("&", "§").replace("{prefix}", LuckPermsUtils.getGroupPrefix("default")).replace("{name}", event.getPlayer().getName()).replace("{message}", event.getMessage()));
        this.sendItem(event);
    }
}
