package fr.kalipso.valorsky.data.player.listener;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProfilePlayerListener extends Manager implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getDataManager().getProfilePlayer().createProfile(event.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent event)
    {
        this.getInstance().getManager().getDataManager().getProfilePlayer().savePlayTime(event);
    }

}
