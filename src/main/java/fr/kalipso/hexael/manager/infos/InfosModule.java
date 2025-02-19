package fr.kalipso.hexael.manager.infos;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
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
