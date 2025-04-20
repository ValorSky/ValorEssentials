package fr.kalipso.valorsky.placeholder.gemmes;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.hEssentials;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class GemmesExpansion extends PlaceholderExpansion {
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
        return "gemmes";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        ProfilePlayer profile = instance.getManager().getDataManager().getPlayer(p.getName());
        if(identifier.equalsIgnoreCase("amount"))
        {
            return String.valueOf(profile.getGemmes());
        }
        return null;
    }
}
