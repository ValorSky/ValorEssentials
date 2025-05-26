package fr.kalipso.valorsky.data.player;

import fr.kalipso.valorsky.data.player.factory.LastSeen;
import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.data.player.provider.ProfilePlayerProvider;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.kits.factory.KitsTime;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.Utils;
import fr.kalipso.valorsky.utils.object.CustomLocation;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerData extends Manager {

    @Getter
    private ProfilePlayerProvider provider;
    public PlayerData()
    {
        this.loadProvider();
    }
    public HashMap<Player, Long> playTime = new HashMap<>();


    public void loadProvider()
    {
        this.provider = new ProfilePlayerProvider();
        this.provider.read();
    }

    public void save()
    {
        this.provider.write();
    }

    public ProfilePlayer getProfile(String name)
    {
        if(provider.get(name) == null)
        {
            MessageUtils.sendLog("Profile inexistant.");
            return null;
        }
        return this.provider.get(name);
    }

    public void createProfile(Player sender)
    {
        if(!this.provider.getProfilePlayerMap().containsKey(sender.getName()))
        {
            ProfilePlayer profilePlayer = new ProfilePlayer(sender.getName(),
                    sender.getUniqueId(),
                    0.0,
                    false,
                    new LastSeen(sender.getAddress().getAddress().toString(), Utils.millisFormat(System.currentTimeMillis()), new CustomLocation(sender.getWorld().getName(), sender.getLocation().getBlockX(), sender.getLocation().getBlockY(), sender.getLocation().getBlockZ())),
                    new HashMap<>(),
                    1,
                    new ArrayList<KitsTime>(),
                    0,
                    0,
                    0);
            this.provider.provide(sender.getName(), profilePlayer);
        }
        this.playTime.put(sender, System.currentTimeMillis());
    }

    public void savePlayTime(PlayerQuitEvent event)
    {
        getProfile(event.getPlayer().getName()).setPlayTime(getProfile(event.getPlayer().getName()).getPlayTime() + (System.currentTimeMillis() - playTime.get(event.getPlayer())));
        playTime.remove(event.getPlayer());
    }
}
