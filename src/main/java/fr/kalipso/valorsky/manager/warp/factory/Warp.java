package fr.kalipso.valorsky.manager.warp.factory;

import fr.kalipso.valorsky.utils.object.CustomLocation;
import lombok.Data;

public @Data class Warp {

    private String name;
    private CustomLocation customLocation;

    public Warp(String name, CustomLocation customLocation)
    {
        this.name = name;
        this.customLocation = customLocation;
    }
}
