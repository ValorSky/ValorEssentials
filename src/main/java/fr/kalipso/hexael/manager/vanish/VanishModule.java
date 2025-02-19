package fr.kalipso.hexael.manager.vanish;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.vanish.task.VanishTask;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishModule extends Manager {

    private List<Player> vanishPlayer = new ArrayList<>();

    public VanishModule()
    {
        new VanishTask();
    }

    public void setVanishPlayer(Player sender)
    {
        if(!vanishPlayer.contains(sender))
        {
            vanishPlayer.add(sender);
            sender.sendMessage(MessageUtils.sendMessage("vanish-set"));
            return;
        }
        vanishPlayer.remove(sender);
        sender.sendMessage(MessageUtils.sendMessage("vanish-unset"));
    }

    public void vanish()
    {
        Bukkit.getOnlinePlayers().forEach(player -> {
            vanishPlayer.forEach(vanishPlayer -> {
                player.hidePlayer(this.getInstance(), vanishPlayer);
            });
        });
    }
}
