package fr.kalipso.hexael.manager.autoannounce.factory;

import lombok.Data;

import java.util.List;

public @Data class AutoAnnounce {

    private int id;
    private List<String> content;

    public AutoAnnounce(int id, List<String> content)
    {
        this.id = id;
        this.content = content;
    }
}
