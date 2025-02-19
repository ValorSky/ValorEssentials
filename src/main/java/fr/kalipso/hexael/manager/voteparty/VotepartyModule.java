package fr.kalipso.hexael.manager.voteparty;

import fr.kalipso.hexael.data.server.factory.ProfileServer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class VotepartyModule extends Manager {

    public void addVoteParty(CommandSender sender)
    {
        sender.sendMessage(MessageUtils.sendMessage("voteparty-add"));
        ProfileServer profile = this.getInstance().getManager().getDataManager().getServer();
        profile.setVotepartyCurrent(profile.getVotepartyCurrent() + 1);
        if(profile.getVotepartyCurrent() >= profile.getVotepartyMax())
        {
            this.finishVoteparty();
        }
    }

    public void finishVoteparty()
    {
        ProfileServer profile = this.getInstance().getManager().getDataManager().getServer();
        profile.setVotepartyCurrent(0);
        Bukkit.getOnlinePlayers().forEach(player -> {
            this.getInstance().getManager().getConfigManager().get("messages").getStringList("voteparty-finish").forEach(line -> {
                player.sendMessage(line);
            });
            this.sendRewards(player);
        });
    }

    public void sendRewards(Player sender)
    {
        List<String> rewards = this.getInstance().getManager().getConfigManager().get("voteparty").getStringList("rewards");
        rewards.forEach(cmd -> {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%", sender.getName()));
        });
    }

    public void setVotepartyMax(Player sender, String value)
    {
        if(!Utils.isInteger(value))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        ProfileServer profile = this.getInstance().getManager().getDataManager().getServer();
        profile.setVotepartyMax(Integer.valueOf(value));
        sender.sendMessage(MessageUtils.sendMessage("voteparty-set-max").replace("%value%", value));
    }

    public void showVoteparty(Player sender)
    {
        ProfileServer profile = this.getInstance().getManager().getDataManager().getServer();
        List<String> msg = this.getInstance().getManager().getConfigManager().get("messages").getStringList("voteparty-show");
        msg.forEach(line -> {
            sender.sendMessage(line.replace("&", "§").replace("%counnt%", String.valueOf(profile.getVotepartyCurrent())));
        });
    }
}
