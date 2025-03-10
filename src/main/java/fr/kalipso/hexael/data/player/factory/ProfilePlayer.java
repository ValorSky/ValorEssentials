package fr.kalipso.hexael.data.player.factory;

import fr.kalipso.hexael.manager.home.factory.Home;
import fr.kalipso.hexael.manager.kits.factory.KitsTime;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public @Data class ProfilePlayer {

    private String name;
    private UUID uuid;
    private Double doublons;
    private boolean isStaff;
    private LastSeen lastSeen;
    private HashMap<String, Home> homeList;
    private int maxHome;
    private List<KitsTime> kitsTake;
    private long flyTime;

    private int gemmes;


    public ProfilePlayer(String name, UUID uuid, double doublons, boolean isStaff, LastSeen lastSeen, HashMap<String, Home> homeList, int maxHome, List<KitsTime> kitsTake, long flyTime, int gemmes)
    {
        this.name = name;
        this.uuid = uuid;
        this.doublons = doublons;
        this.isStaff = isStaff;
        this.lastSeen = lastSeen;
        this.homeList = homeList;
        this.maxHome = maxHome;
        this.kitsTake = kitsTake;
        this.flyTime = flyTime;
        this.gemmes = gemmes;
    }


    public void depositDoublons(double montant)
    {
        doublons  = doublons  + montant;
    }
    public void withdrawDoublons(double montant)
    {
        doublons  = doublons  - montant;
    }
    public void takeTimeFly()
    {
        this.setFlyTime(this.flyTime - 1000);
    }

}
