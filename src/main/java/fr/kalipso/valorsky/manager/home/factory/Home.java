package fr.kalipso.valorsky.manager.home.factory;

import fr.kalipso.valorsky.utils.object.CustomLocation;
import lombok.Data;

public @Data class Home {

    private String name;
    private CustomLocation customLocation;

    public Home(String name, CustomLocation customLocation)
    {
        this.name = name;
        this.customLocation = customLocation;
    }
}
