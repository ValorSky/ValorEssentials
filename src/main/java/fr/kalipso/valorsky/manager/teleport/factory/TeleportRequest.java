package fr.kalipso.valorsky.manager.teleport.factory;

import lombok.Data;
import org.bukkit.entity.Player;

public @Data class TeleportRequest {

    private Player sender, target;

    public TeleportRequest(Player sender, Player target)
    {
        this.sender = sender;
        this.target = target;
    }
}
