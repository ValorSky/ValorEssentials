package fr.kalipso.valorsky.utils;


import org.bukkit.ChatColor;

public class Color {

    public static String translate(String line) {
        return ChatColor.translateAlternateColorCodes('&', line);
    }

    public static String strip(String line) {
        return ChatColor.stripColor(line);
    }
}