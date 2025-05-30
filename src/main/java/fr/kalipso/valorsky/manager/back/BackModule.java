package fr.kalipso.valorsky.manager.back;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.TeleportationUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class BackModule extends Manager {

    private HashMap<UUID, Location> previousLoc = new HashMap<>();

    public void addPreviousLoc(Player sender, Location loc)
    {
        if(previousLoc.containsKey(sender.getUniqueId()))
        {
            previousLoc.remove(sender.getUniqueId());
            previousLoc.put(sender.getUniqueId(), loc);
        }
        else
        {
            previousLoc.put(sender.getUniqueId(), loc);
        }
    }

    public void backPlayer(Player sender)
    {
        if(!previousLoc.containsKey(sender.getUniqueId()))
        {
            sender.sendMessage(MessageUtils.sendError("back-no-previous"));
        }
        else
        {
            TeleportationUtils.teleport(sender, previousLoc.get(sender.getUniqueId()), "Précédentes Position");
        }
    }
}
