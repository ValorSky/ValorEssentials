package fr.kalipso.hexael.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

/**
 * @author Kalipso
 */
public class ActionBarUtils {

    public static void sendActionBar(Player sender, Component msg)
    {
        sender.sendActionBar(msg);
    }

}