package fr.kalipso.valorsky.manager.feed;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.feed.task.FeedTask;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FeedModule extends Manager {

    private List<Player> playerFeed = new ArrayList<>();

    public FeedModule()
    {
        this.autoFeed();
    }

    public void feedPlayer(Player sender)
    {
        sender.setFoodLevel(20);
        sender.sendMessage(MessageUtils.sendMessage("feed"));
    }

    public void feedPlayer(Player sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        sender.sendMessage(MessageUtils.sendMessage("feed-other").replace("%target%", target.getName()));
        feedPlayer(target);
    }

    public void autoFeed()
    {
        Bukkit.getScheduler().runTaskTimerAsynchronously(getInstance(), new FeedTask(), 20 * 60, 20 * 60);
    }

    public boolean isAutofeed(Player sender)
    {
        return playerFeed.contains(sender);
    }

    public void setAutofeed(Player sender)
    {
        if(playerFeed.contains(sender))
        {
            sender.sendMessage(MessageUtils.sendMessage("feed-off"));
            playerFeed.remove(sender);
            return;
        }
        sender.sendMessage(MessageUtils.sendMessage("feed-on"));
        playerFeed.add(sender);
    }
}
