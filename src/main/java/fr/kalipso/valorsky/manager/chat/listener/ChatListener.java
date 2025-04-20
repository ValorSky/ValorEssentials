package fr.kalipso.valorsky.manager.chat.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener extends Manager implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        this.getInstance().getManager().getChatManager().sendChat(event);
        this.getInstance().getManager().getChatManager().sendItem(event);
    }


}
