package fr.kalipso.hexael.manager.home;

import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.home.factory.Home;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.TeleportationUtils;
import fr.kalipso.hexael.utils.Utils;
import fr.kalipso.hexael.utils.object.CustomLocation;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HomeModule extends Manager {

    public void teleportHome(Player sender, String name)
    {
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());
        if(!profile.getHomeList().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("home-no-exist"));
            return;
        }
        TeleportationUtils.teleport(sender, profile.getHomeList().get(name).getCustomLocation().toLocation(), name);
    }

    public void setHome(Player sender, String name)
    {
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());
        if(profile.getHomeList().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("home-already-exist"));
            return;
        }
        if(sender.hasPermission("essentials.home")) {
            sender.getEffectivePermissions().forEach(perm -> {
                String perms = perm.getPermission();
                if (perms.contains("essentials.home.")) {
                    String[] permission = perms.split("home.");
                    if (Utils.isInteger(permission[1])) {
                        int maxHome = Integer.valueOf(permission[1]);
                        if (profile.getHomeList().size() == maxHome) {
                            sender.sendMessage(MessageUtils.sendError("home-max-reached"));
                            return;
                        }
                    }

                }
            });
            return;
        }
        Home home = new Home(name, new CustomLocation(sender.getWorld().getName(), sender.getLocation().getBlockX(), sender.getLocation().getBlockY(), sender.getLocation().getBlockZ()));
        profile.getHomeList().put(name, home);
        sender.sendMessage(MessageUtils.sendMessage("home-set").replace("%name%", name));
    }

    public void removeHome(Player sender, String name)
    {
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());
        if(!profile.getHomeList().containsKey(name))
        {
            sender.sendMessage(MessageUtils.sendError("home-no-exist"));
            return;
        }
        profile.getHomeList().remove(name);
        sender.sendMessage(MessageUtils.sendMessage("home-remove").replace("%name%", name));
    }

    public void showList(Player sender)
    {
        List<String> msg = new ArrayList<>();
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());

        msg.add("§7§m-----------------");
        msg.add("");
        for(String name : profile.getHomeList().keySet())
        {
            msg.add("§b§l" + name);
        }
        msg.add("");
        msg.add("§7§m-----------------");


        msg.forEach(line -> {
            sender.sendMessage(line);

        });
    }

    public void showHelp(Player sender)
    {
        sender.sendMessage("§7§m------------------");
        sender.sendMessage("");
        sender.sendMessage("§f/home §7- §bAffiche l'aide des résidences");
        sender.sendMessage("§f/home <nom> §7- §bTéléporte à la résidence");
        sender.sendMessage("§f/home list §7- §bAffiche la liste des résidences");
        sender.sendMessage("§f/home create <nom> §7- §bCrée une résidence");
        sender.sendMessage("§f/home delete <nom> §7- §bSupprime une résidence");
        sender.sendMessage("");
        sender.sendMessage("§7§m------------------");
    }
}
