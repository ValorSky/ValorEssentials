package fr.kalipso.valorsky.data.player.factory;

import fr.kalipso.valorsky.utils.object.CustomLocation;
import lombok.Data;

public @Data class LastSeen {

    private String ip, date;
    private CustomLocation lastLocation;

    public LastSeen(String ip, String date, CustomLocation lastLocation)
    {
        this.ip = ip;
        this.date = date;
        this.lastLocation = lastLocation;
    }
}
