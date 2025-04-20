package fr.kalipso.valorsky.manager.fly.task;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FlyTask extends BukkitRunnable {

    private hEssentials instance = hEssentials.getInstance();
    private Player player;

    public FlyTask(Player sender) {
        this.player = sender;
    }

    @Override
    public void run() {
        ProfilePlayer profile = this.instance.getManager().getDataManager().getPlayer(player.getName());
        profile.takeTimeFly();
        if(profile.getFlyTime() <= 0)
        {
            player.setFlying(false);
            player.setAllowFlight(false);
            player.sendMessage(MessageUtils.sendMessage("fly-desactive"));
            instance.getManager().getFlyModule().getFlying().remove(player);
            instance.getManager().getFlyModule().getTaskPlayers().remove(player.getUniqueId());
            this.cancel();
        }
    }
}
