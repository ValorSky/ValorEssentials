package fr.kalipso.valorsky.placeholder.voteparty;

import fr.kalipso.valorsky.data.server.factory.ProfileServer;
import fr.kalipso.valorsky.hEssentials;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class VotepartyExpansion extends PlaceholderExpansion {
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
        return "voteparty";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        ProfileServer profile = instance.getManager().getDataManager().getServer();
        if(identifier.equalsIgnoreCase("formatted"))
        {
            return "<light_purple>" + profile.getVotepartyCurrent() + "<dark_purple>/<light_purple>" + profile.getVotepartyMax();
        }
        else if(identifier.equalsIgnoreCase("count"))
        {
            return String.valueOf(profile.getVotepartyCurrent());
        }
        else if(identifier.equalsIgnoreCase("max"))
        {
            return String.valueOf(profile.getVotepartyMax());

        }
        return null;
    }
}
