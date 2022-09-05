package me.beary.weather.listeners;

import lombok.Getter;
import me.beary.DynamicWeather;
import me.beary.weather.impl.Weather;
import me.beary.weather.impl.WeatherPlayer;
import me.beary.util.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.PlayerInventory;

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

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        Player player = (Player) e.getPlayer();
        player.sendMessage(String.valueOf(e.getInventory() instanceof PlayerInventory));

    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent e) {
        if(!e.getPlayer().isSneaking()) {
            Weather weather = DynamicWeather.getInst().getWeather();
            ActionBar actionBar = new ActionBar(e.getPlayer(), "§b" + weather.getTemperature() + "°C §8| §a" + weather.getConditions());
            actionBar.runTaskTimer(DynamicWeather.getInst(), 0, 10);
        }
    }

}
