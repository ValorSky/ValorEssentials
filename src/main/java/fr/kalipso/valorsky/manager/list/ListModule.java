package fr.kalipso.valorsky.manager.list;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicInteger;

public class ListModule extends Manager {

    public void sendList(Player sender)
    {
        this.getInstance().getManager().getConfigManager().get("messages").getStringList("list-msg").forEach(line -> {
                sender.sendMessage(line.replace("%count%", String.valueOf(Bukkit.getOnlinePlayers().size())
                        .replace("%staff_count%", getStaffCount())));
        });
    }

    public String getStaffCount()
    {
        AtomicInteger count = new AtomicInteger(0);
        Bukkit.getOnlinePlayers().forEach(player -> {
           ProfilePlayer profilePlayer = getInstance().getManager().getDataManager().getPlayer(player.getName());
           if(profilePlayer.isStaff()) count.getAndAdd(1);
        });
        return String.valueOf(count.get());
    }
}
