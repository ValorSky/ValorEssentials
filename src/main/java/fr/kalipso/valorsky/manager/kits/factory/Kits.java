package fr.kalipso.valorsky.manager.kits.factory;

import fr.kalipso.valorsky.utils.object.ItemContent;
import lombok.Data;

import java.util.List;

public @Data class Kits {

    private String name;
    private List<ItemContent> contents;
    private int delay;
    private String permission;

    public Kits(String name, List<ItemContent> contents, int delay, String permission)
    {
        this.name = name;
        this.contents = contents;
        this.delay = delay;
        this.permission = permission;
    }
}
