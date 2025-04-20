package fr.kalipso.valorsky.manager.infos;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

public class InfosModule extends Manager {

    public void sendSite(Player sender)
    {
        sender.sendMessage(MessageUtils.sendMessage("infos-site"));
    }

    public void sendShop(Player sender)
    {
        sender.sendMessage(MessageUtils.sendMessage("infos-shop"));
    }

}
