package me.beary.util;

import org.bukkit.Bukkit;

public class Util {

    public static void sendBoldMessageToConsole(String message) {
        Bukkit.getConsoleSender().sendMessage("§b[DynamicWeather] " + message);
    }

}
