package me.beary.listeners;

import lombok.Getter;
import me.beary.weather.WeatherPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class PlayerListener implements Listener {

    @Getter
    private static HashMap<Player, WeatherPlayer> players = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        players.put(e.getPlayer(), new WeatherPlayer(e.getPlayer()));
        Bukkit.getLogger().info("Added " + e.getPlayer().getName() + " to WeatherPlayer");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        players.remove(e.getPlayer());
        Bukkit.getLogger().info("Removed " + e.getPlayer().getName() + " from WeatherPlayer");
    }

}
