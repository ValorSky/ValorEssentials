package fr.kalipso.hexael.manager.kits.factory;

import lombok.Data;

public @Data class KitsTime {

    private String name;
    private long lastTake;

    public KitsTime(String name, long lastTake)
    {
        this.name = name;
        this.lastTake = lastTake;
    }

    public KitsTime getByName(String name)
    {
        return this;
    }
}
