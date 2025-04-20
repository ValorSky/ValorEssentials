package fr.kalipso.valorsky.manager.joinquit.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener extends Manager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getJoinQuitModule().setJoinMessage(event);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        this.getInstance().getManager().getJoinQuitModule().setQuitMessage(event);
    }
}
