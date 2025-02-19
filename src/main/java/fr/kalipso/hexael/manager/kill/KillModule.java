package fr.kalipso.hexael.manager.kill;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.entity.Monster;
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
            if(entity instanceof Monster)
            {
                ((Monster) entity).setLastDamage(2000);
            }
        });
        sender.sendMessage(MessageUtils.sendMessage("kill-player").replace ("%target", "les Monstres"));
    }
}
