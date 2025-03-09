package fr.kalipso.hexael.manager.seen;

import fr.kalipso.hexael.data.player.factory.LastSeen;
import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.Utils;
import fr.kalipso.hexael.utils.object.CustomLocation;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class SeenModule extends Manager {

    public void setLastSeen(Player target)
    {
        LastSeen lastSeen = new LastSeen(target.getAddress().getAddress().toString(), Utils.millisFormat(System.currentTimeMillis()), new CustomLocation(target.getWorld().getName(), target.getLocation().getBlockX(), target.getLocation().getBlockY(), target.getLocation().getBlockZ()));
        if(this.getInstance().getManager().getDataManager().getPlayer(target.getName()) == null)
        {
            return;
        }
        ProfilePlayer profilePlayer = this.getInstance().getManager().getDataManager().getPlayer(target.getName());
        profilePlayer.setLastSeen(lastSeen);
    }

    public void sendLastSeen(Player sender, Player target, String name)
    {

        if(target == null)
        {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);
            ProfilePlayer profilePlayer = this.getInstance().getManager().getDataManager().getPlayer(offlinePlayer.getName());
            if(profilePlayer.getLastSeen() == null)
            {
                sender.sendMessage(MessageUtils.sendError("seen-no-last"));
                return;
            }
            this.getInstance().getManager().getConfigManager().get("messages").getStringList("seen").forEach(line -> {
                String loc = "§bx: " + profilePlayer.getLastSeen().getLastLocation().toString();
                sender.sendMessage(line
                        .replace("&", "§")
                        .replace("%target%", target.getName())
                        .replace("%adresse%", profilePlayer.getLastSeen().getIp())
                        .replace("%date%", profilePlayer.getLastSeen().getDate())
                        .replace("%pos%", loc)
                );
            });
            return;
        }
        ProfilePlayer profilePlayer = this.getInstance().getManager().getDataManager().getPlayer(target.getName());
        if(profilePlayer.getLastSeen() == null)
        {
            sender.sendMessage(MessageUtils.sendError("seen-no-last"));
            return;
        }
        this.getInstance().getManager().getConfigManager().get("messages").getStringList("seen").forEach(line -> {
            String loc = "§bx: " + profilePlayer.getLastSeen().getLastLocation().toString();
            sender.sendMessage(line
                    .replace("&", "§")
                    .replace("%target%", target.getName())
                    .replace("%adresse%", profilePlayer.getLastSeen().getIp())
                    .replace("%date%", profilePlayer.getLastSeen().getDate())
                    .replace("%pos%", loc)
            );
        });
    }
}
