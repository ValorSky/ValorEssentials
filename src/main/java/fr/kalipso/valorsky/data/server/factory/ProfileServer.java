package fr.kalipso.valorsky.data.server.factory;

import fr.kalipso.valorsky.manager.warp.factory.Warp;
import fr.kalipso.valorsky.utils.object.CustomLocation;
import lombok.Data;

import java.util.HashMap;

public @Data class ProfileServer {

    private String name;
    private CustomLocation spawnLocation;
    private int playerCount, votepartyCurrent, votepartyMax;
    private HashMap<String, Warp> warps;

    public ProfileServer(String name, CustomLocation spawnLocation, int playerCount, HashMap<String, Warp> warps, int votepartyCurrent, int votepartyMax)
    {
        this.name = name;
        this.spawnLocation = spawnLocation;
        this.playerCount = playerCount;
        this.warps = warps;
        this.votepartyCurrent = votepartyCurrent;
        this.votepartyMax = votepartyMax;
    }
}
