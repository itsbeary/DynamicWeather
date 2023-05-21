package me.beary.listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import lombok.Getter;
import me.beary.DynamicWeather;
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
    private final static HashMap<Player, WeatherPlayer> players = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        players.put(e.getPlayer(), new WeatherPlayer(e.getPlayer()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        players.remove(e.getPlayer());
    }

    @EventHandler
    public void onInteract(PlayerArmorChangeEvent event) {
        if(event.getNewItem() == null) {
            updateTemperature(event.getPlayer(), 0);
            return;
        }
        if(event.getNewItem().getType().toString().contains("NETHERITE")) {
            updateTemperature(event.getPlayer(), 6.5);
            return;
        }
        if(event.getNewItem().getType().toString().contains("DIAMOND")) {
            updateTemperature(event.getPlayer(), 4);
            return;
        }
        if(event.getNewItem().getType().toString().contains("IRON") || event.getNewItem().getType().toString().contains("GOLD")) {
            updateTemperature(event.getPlayer(), 3);
            return;
        }
        if(event.getNewItem().getType().toString().contains("LEATHER")) {
            updateTemperature(event.getPlayer(), 2);
            return;
        }
        if(event.getNewItem().getType().toString().contains("CHAINMAIL"))
            updateTemperature(event.getPlayer(), 1);
    }

    public void updateTemperature(Player player, double temp) {
        if(!DynamicWeather.getInst().getConfigManager().isUseTrueTemperature())
            return;
        players.get(player).setTemperature(DynamicWeather.getInst().getWeather().getTemperature() + temp);
    }

}
