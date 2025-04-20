package fr.kalipso.valorsky.manager.coloredchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColoredChatModule implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        event.setMessage(event.getMessage().replace("&", "§"));
    }
}
