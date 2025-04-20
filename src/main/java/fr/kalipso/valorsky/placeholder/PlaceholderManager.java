package fr.kalipso.valorsky.placeholder;


import fr.kalipso.valorsky.placeholder.fly.FlyExpansion;
import fr.kalipso.valorsky.placeholder.gemmes.GemmesExpansion;
import fr.kalipso.valorsky.placeholder.voteparty.VotepartyExpansion;

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
