package fr.kalipso.hexael.data;

import fr.kalipso.hexael.data.player.PlayerData;
import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.data.server.ServerData;
import fr.kalipso.hexael.data.server.factory.ProfileServer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import lombok.Getter;
import org.bukkit.entity.Player;

public class DataManager extends Manager {

    @Getter private PlayerData profilePlayer;
    @Getter private ServerData profileServer;

    public void loadProfiles()
    {
        this.profileServer = new ServerData();
        this.profilePlayer = new PlayerData();
    }

    public void saveData()
    {
        this.profileServer.save();
        this.profilePlayer.save();
        this.getInstance().getManager().getKitsModule().saveData();
        MessageUtils.sendLog("Données sauvegardés avec succès.");
    }

    public void resetProfile(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
    }

    public ProfileServer getServer()
    {
        return profileServer.getProvider().get(getInstance().getManager().getConfigManager().get("main").getString("server-name"));
    }

    public ProfilePlayer getPlayer(String name)
    {
        return profilePlayer.getProvider().get(name);
    }
    public ProfilePlayer getPlayer(Player name)
    {
        return profilePlayer.getProvider().get(name.getName());
    }
}
