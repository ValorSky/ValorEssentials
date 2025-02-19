package fr.kalipso.hexael.placeholder.fly;

import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.hEssentials;
import fr.kalipso.hexael.utils.Utils;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class FlyExpansion extends PlaceholderExpansion {
    private hEssentials instance = hEssentials.getInstance();

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return "Kalipso";
    }

    @Override
    public String getIdentifier() {
        return "fly";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        ProfilePlayer profile = instance.getManager().getDataManager().getPlayer(p.getName());
        if(identifier.equalsIgnoreCase("count"))
        {
            if(profile.getFlyTime() <= 0)
            {
                return "Aucun";
            }
            else if(p.hasPermission("essentials.fly.bypass") || p.isOp())
            {
                return "Illimité";
            }
            return Utils.millisFormat(profile.getFlyTime());
        }
        return null;
    }
}
