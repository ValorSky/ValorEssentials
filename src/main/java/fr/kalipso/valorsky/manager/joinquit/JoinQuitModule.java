package fr.kalipso.valorsky.manager.joinquit;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitModule extends Manager {

    public void setJoinMessage(PlayerJoinEvent event)
    {
        if(!event.getPlayer().hasPlayedBefore())
        {
            this.getInstance().getManager().getDataManager().getServer().setPlayerCount(this.getInstance().getManager().getDataManager().getServer().getPlayerCount() + 1);
            event.setJoinMessage(this.getInstance().getManager().getConfigManager().get("main").getString("new-player-format")
                    .replace("%player%", event.getPlayer().getName())
                    .replace("%player_count%", String.valueOf(this.getInstance().getManager().getDataManager().getServer().getPlayerCount())));
        }
        else
        {
            this.sendJoinMessage(event);
        }
    }

    public void sendJoinMessage(PlayerJoinEvent event)
    {
        if(this.getInstance().getManager().getConfigManager().get("main").getBoolean("silent-join"))
        {
            event.setJoinMessage("");
        }
        else
        {
            event.setJoinMessage(this.getInstance().getManager().getConfigManager().get("main").getString("join-format").replace("%player%", event.getPlayer().getName()));
        }
    }

    public void setQuitMessage(PlayerQuitEvent event)
    {
        if(this.getInstance().getManager().getConfigManager().get("main").getBoolean("silent-join"))
        {
            event.setQuitMessage("");
        }
        else
        {
            event.setQuitMessage(this.getInstance().getManager().getConfigManager().get("main").getString("quit-format").replace("%player%", event.getPlayer().getName()));
        }
    }
}
