package fr.kalipso.hexael.manager.privatemessage.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PrivateMessageListener extends Manager implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        this.getInstance().getManager().getPrivateMessageManager().removeIgnoreList(event.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getPrivateMessageManager().createIgnoreList(event.getPlayer());
    }
}
