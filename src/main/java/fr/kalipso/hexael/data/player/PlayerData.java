package fr.kalipso.hexael.data.player;

import fr.kalipso.hexael.data.player.factory.LastSeen;
import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.data.player.provider.ProfilePlayerProvider;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.kits.factory.KitsTime;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.Utils;
import fr.kalipso.hexael.utils.object.CustomLocation;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerData extends Manager {

    @Getter
    private ProfilePlayerProvider provider;
    public PlayerData()
    {
        this.loadProvider();
    }

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
                    new ArrayList<KitsTime>(),
                    0,
                    0);
            this.provider.provide(sender.getName(), profilePlayer);
        }
    }
}
