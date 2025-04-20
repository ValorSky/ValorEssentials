package fr.kalipso.valorsky.utils;

import fr.kalipso.valorsky.hEssentials;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageUtils {

    private static hEssentials instance = hEssentials.getInstance();
    private static HashMap<String, String> colors = new HashMap<>();

    public MessageUtils()
    {
        this.loadColors();
    }


    public void loadColors()
    {
        colors.put("<black>", "§0");
        colors.put("<dark_blue>", "§1");
        colors.put("<dark_green>", "§2");
        colors.put("<dark_aqua>", "§3");
        colors.put("<dark_red>", "§4");
        colors.put("<dark_purple>", "§5");
        colors.put("<gold>", "§6");
        colors.put("<gray>", "§7");
        colors.put("<dark_gray>", "§8");
        colors.put("<green>", "§a");
        colors.put("<aqua>", "§b");
        colors.put("<red>", "§c");
        colors.put("<light_purple>", "§d");
        colors.put("<yellow>", "§e");
        colors.put("<white>", "§f");
    }

    public static String sendMessage(String name) {
        return instance.getManager().getConfigManager().get("messages").getString("prefix") + instance.getManager().getConfigManager().get("messages").getString(name).replace("&", "§");
    }
    public static String sendAlert(String name) {
        return instance.getManager().getConfigManager().get("messages").getString("alert") + instance.getManager().getConfigManager().get("messages").getString(name).replace("&", "§");
    }
    public static void sendAllMessage(String list)
    {
        Bukkit.getOnlinePlayers().forEach(player ->  {
            player.sendMessage(list);
        });
    }

    public static void sendAllMessage(List<String> list)
    {
        Bukkit.getOnlinePlayers().forEach(player ->  {
            list.forEach(line -> {
                player.sendMessage(line);
            });
        });
    }
    public static String sendMessageNoPrefix(String name) { return instance.getManager().getConfigManager().get("messages").getString(name);}
    public static String sendError(String name) { return instance.getManager().getConfigManager().get("messages").getString("erreur") + instance.getManager().getConfigManager().get("messages").getString(name).replace("&", "§");}

    public static String formatColor(String msg)
    {
        AtomicReference<String> message = new AtomicReference<>("");
        colors.keySet().forEach(line -> {
            message.set(msg.replace(line, colors.get(line)));
        });
        return message.get();
    }

    public static void sendLog(String message)
    {
        Logger logger = Bukkit.getLogger();
        logger.log(Level.INFO, message);
    }
}
