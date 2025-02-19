package fr.kalipso.hexael.manager.fly.listener;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.fly.task.FlyTask;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FlyListener extends Manager implements Listener {

    @EventHandler
    public void onFly(PlayerToggleFlightEvent event)
    {
        if(event.isFlying())
        {
            if(this.getInstance().getManager().getFlyModule().getTaskPlayers().containsKey(event.getPlayer().getUniqueId()))
            {
                Bukkit.getScheduler().cancelTask(this.getInstance().getManager().getFlyModule().getTaskPlayers().get(event.getPlayer().getUniqueId()));
                this.getInstance().getManager().getFlyModule().getTaskPlayers().remove(event.getPlayer().getUniqueId());
                this.getInstance().getManager().getFlyModule().getFlying().remove(event.getPlayer());

            }
        }
        else
        {
            if(!event.getPlayer().hasPermission("essentials.fly.bypass"))
            {
                this.getInstance().getManager().getFlyModule().getTaskPlayers().put(event.getPlayer().getUniqueId(), new FlyTask(event.getPlayer()).runTaskTimerAsynchronously(this.getInstance(), 0, this.getInstance().getManager().getDataManager().getPlayer(event.getPlayer().getName()).getFlyTime()).getTaskId());
                this.getInstance().getManager().getFlyModule().getFlying().add(event.getPlayer());

            }
        }
    }
}
