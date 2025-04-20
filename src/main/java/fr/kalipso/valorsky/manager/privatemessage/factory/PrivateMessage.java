package fr.kalipso.valorsky.manager.privatemessage.factory;

import lombok.Data;
import org.bukkit.entity.Player;

public @Data class PrivateMessage {

    private Player sender;
    private Player target;
    private String message;

    public PrivateMessage(Player sender, Player target, String message)
    {
        this.sender = sender;
        this.target = target;
        this.message = message;
    }
}
