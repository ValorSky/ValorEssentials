package fr.kalipso.hexael.utils;

import fr.kalipso.hexael.hEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TeleportationUtils {

    private static hEssentials instance = hEssentials.getInstance();
    private static int cooldown;

    public TeleportationUtils()
    {
        this.cooldown = instance.getManager().getConfigManager().get("main").getInt("teleport-delay");
    }

    public static void randomTeleport(Player target, World world, int min, int max)
    {
        if(world == null)
        {
            target.sendMessage(MessageUtils.sendError("no-world"));
            return;
        }
        int x = randomCoords(min, max);
        int z = randomCoords(min, max);
        target.teleport(new Location(world, x, world.getHighestBlockYAt(x, z), z));
    }

    public static void teleportRandomCooldown(Player target,final AtomicInteger cooldown, World world, int min, int max)
    {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(instance, new BukkitRunnable() {
            @Override
            public void run() {
                AtomicInteger cd = cooldown;
                target.sendMessage(MessageUtils.sendMessage("message-teleport-cooldown").replace("%time%", String.valueOf(cd.get())));
                cd.getAndDecrement();
                if(cd.get() <= 0)
                {
                    target.sendMessage(MessageUtils.sendMessage("message-teleport").replace("%name%", world.getName()));
                    randomTeleport(target, world, min, max);
                    this.cancel();
                }
            }
        }, 0, 20);
    }

    public static void teleport(Player sender, Location loc, String name)
    {
        if(!sender.hasPermission("essentials.teleport.bypass"))
        {
            teleportCooldown(sender, loc, name);
            return;
        }
        sender.teleport(loc);
        sender.sendMessage(MessageUtils.sendMessage("teleport-at").replace("%name%", name));
    }

    public static void teleportCooldown(Player sender, Location loc, String name)
    {
        sender.sendMessage(MessageUtils.sendMessage("teleport-cooldown").replace("%time%", String.valueOf(cooldown)));
        Location senderLoc = sender.getLocation();
        Bukkit.getScheduler().runTaskLaterAsynchronously(instance, new Runnable() {
            @Override
            public void run() {
                sender.teleport(loc);
                sender.sendMessage(MessageUtils.sendMessage("teleport-at").replace("%name%", name));
            }
        }, 20 * cooldown);
    }

    public static int randomCoords(int min, int max)
    {
        int rd = max-min;
        return new Random().nextInt((rd + 1) + min);
    }
}
