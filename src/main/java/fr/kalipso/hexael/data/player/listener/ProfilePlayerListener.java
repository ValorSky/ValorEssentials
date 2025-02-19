package fr.kalipso.hexael.data.player.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfilePlayerListener extends Manager implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        this.getInstance().getManager().getDataManager().getProfilePlayer().createProfile(event.getPlayer());
    }

}
