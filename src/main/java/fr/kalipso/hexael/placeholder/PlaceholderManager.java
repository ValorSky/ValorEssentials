package fr.kalipso.hexael.placeholder;


import fr.kalipso.hexael.placeholder.fly.FlyExpansion;
import fr.kalipso.hexael.placeholder.gemmes.GemmesExpansion;
import fr.kalipso.hexael.placeholder.voteparty.VotepartyExpansion;

public class PlaceholderManager {

    public PlaceholderManager()
    {
        this.loadPlaceholder();
    }

    public void loadPlaceholder()
    {
        new FlyExpansion().register();
        new GemmesExpansion().register();
        new VotepartyExpansion().register();
    }
}
