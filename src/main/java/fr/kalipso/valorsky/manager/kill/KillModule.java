package fr.kalipso.valorsky.manager.kill;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.entity.Player;

public class KillModule extends Manager {

    public void killPlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        target.setLastDamage(200);
        sender.sendMessage(MessageUtils.sendMessage("kill-player").replace("%target%", target.getName()));
    }

    public void killEntities(Player sender)
    {
        sender.getWorld().getEntities().forEach(entity -> {
            if(entity instanceof Player)return;
            entity.remove();
        });
        sender.sendMessage("§aEntités supprimées.");
    }
}
