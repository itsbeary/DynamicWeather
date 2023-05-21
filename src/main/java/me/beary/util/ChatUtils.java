package me.beary.util;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String prefixFormat(String message) {
        return ChatColor.translateAlternateColorCodes('&', "&3&lDynamicWeather &8| &b" + message);
    }

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
