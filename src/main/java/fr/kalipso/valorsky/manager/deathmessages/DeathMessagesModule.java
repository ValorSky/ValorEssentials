package fr.kalipso.valorsky.manager.deathmessages;

import fr.kalipso.valorsky.manager.Manager;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeathMessagesModule extends Manager {

    private List<String> messages = new ArrayList<>();

    public DeathMessagesModule()
    {
        this.loadMessages();
    }

    public void loadMessages()
    {
        this.getInstance().getManager().getConfigManager().get("deathmessage").getStringList("messages").forEach(line -> {
            messages.add(line.replace("&", "§"));
        });
    }

    public void sendMessages(PlayerDeathEvent event)
    {
        if(this.getInstance().getManager().getConfigManager().get("deathmessage").getBoolean("enabled"))
        {
            String msg = messages.get(new Random().nextInt(messages.size()));
            event.setDeathMessage(msg.replace("%player%", event.getEntity().getName())
                    .replace("%killer%", event.getEntity().getKiller().getName()));
        }
        else
        {
            event.setDeathMessage("");
        }
    }

}
