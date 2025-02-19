package fr.kalipso.hexael.manager.fly;

import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.fly.task.FlyTask;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.Utils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class FlyModule extends Manager {

    @Getter private List<Player> flying = new ArrayList<>();
    @Getter
    private HashMap<UUID, Integer> taskPlayers = new HashMap<>();

    public void flyPlayer(Player sender)
    {
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());
        if(!isFlying(sender))
        {
            if(sender.hasPermission("essentials.fly.bypass") || sender.isOp())
            {
                sender.setFlying(true);
                sender.setAllowFlight(true);
                sender.sendMessage(MessageUtils.sendMessage("fly-active"));
                flying.add(sender);
            }
            else if(profile.getFlyTime() < 0)
            {
                sender.sendMessage(MessageUtils.sendError("fly-no-time"));
            }
            else if(profile.getFlyTime() > 0)
            {
                sender.setFlying(true);
                sender.setAllowFlight(true);
                flying.add(sender);
                sender.sendMessage(MessageUtils.sendMessage("fly-active"));
                taskPlayers.put(sender.getUniqueId(), new FlyTask(sender).runTaskTimerAsynchronously(this.getInstance(), 0, profile.getFlyTime()).getTaskId());

            }
        }
        else
        {
            if(sender.hasPermission("essentials.fly.bypass") || sender.isOp())
            {
                sender.setFlying(false);
                sender.setAllowFlight(false);
                sender.sendMessage(MessageUtils.sendMessage("fly-desactive"));
            }
            else if(profile.getFlyTime() < 0)
            {
                sender.setFlying(false);
                sender.setAllowFlight(false);
                sender.sendMessage(MessageUtils.sendError("fly-no-time"));
            }
            else if(profile.getFlyTime() > 0)
            {
                sender.setFlying(false);
                sender.setAllowFlight(false);
                flying.remove(sender);
                sender.sendMessage(MessageUtils.sendMessage("fly-desactive"));
                Bukkit.getScheduler().cancelTask(taskPlayers.get(sender.getUniqueId()));
                taskPlayers.remove(sender.getUniqueId());

            }
        }
    }

    public void addTempFly(CommandSender sender, Player target, String time)
    {
        ProfilePlayer profileTarget = this.getInstance().getManager().getDataManager().getPlayer(target.getName());
        if(profileTarget == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(!Utils.isInteger(time))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        profileTarget.setFlyTime(profileTarget.getFlyTime() + (Integer.valueOf(time) * 1000));
        sender.sendMessage(MessageUtils.sendMessage("fly-add").replace("%time%", time));
        target.sendMessage(MessageUtils.sendMessage("fly-receive").replace("%time%", time));
    }

    public boolean checkIfHaveFly(Player target)
    {
        return false;
    }

    public boolean isFlying(Player target)
    {
        return flying.contains(target);
    }
}
