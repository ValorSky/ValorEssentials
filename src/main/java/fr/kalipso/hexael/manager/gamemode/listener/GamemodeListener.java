package fr.kalipso.hexael.manager.gamemode.listener;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GamemodeListener extends Manager implements Listener {

    @EventHandler
    public void onChangeGamemode(PlayerGameModeChangeEvent event)
    {
        this.getInstance().getManager().getGamemodeModule().sendGamemodeMessage(event);
    }
}
