package fr.kalipso.hexael.manager.feed.task;

import fr.kalipso.hexael.manager.Manager;
import org.bukkit.Bukkit;

public class FeedTask extends Manager implements Runnable {
    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if(this.getInstance().getManager().getFeedModule().isAutofeed(player))
            {
                this.getInstance().getManager().getFeedModule().feedPlayer(player);
            }
        });
    }
}
