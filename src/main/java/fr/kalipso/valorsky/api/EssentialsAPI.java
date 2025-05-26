package fr.kalipso.valorsky.api;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.Utils;
import org.bukkit.entity.Player;

public class EssentialsAPI extends Manager {

    public static long getPlayTime(Player player)
    {
        ProfilePlayer profile = hEssentials.getInstance().getManager().getDataManager().getPlayer(player);
        return profile.getPlayTime();
    }

    public static String getPlayTimeFormatted(Player player)
    {
        return Utils.millisFormat(getPlayTime(player));
    }

    public static int getGemmes(Player player)
    {
        ProfilePlayer profile = hEssentials.getInstance().getManager().getDataManager().getPlayer(player);
        return profile.getGemmes();
    }

    public boolean hasGemmes(Player player, int gemmes)
    {
        ProfilePlayer profile = hEssentials.getInstance().getManager().getDataManager().getPlayer(player);
        if(gemmes >= profile.getGemmes())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
