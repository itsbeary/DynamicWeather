package me.beary.weather.listeners;

import lombok.Getter;
import me.beary.DynamicWeather;
import me.beary.util.ConfigReader;
import me.beary.weather.ArmorManager;
import me.beary.weather.impl.ServerWeather;
import me.beary.weather.impl.WeatherPlayer;
import me.beary.util.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PlayerListener implements Listener {

    @Getter
    private static HashMap<Player, WeatherPlayer> players = new HashMap<>();

    ConfigReader configReader =new ConfigReader();
    ArmorManager armorManager = new ArmorManager();


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
    public void onPlayerSneak(PlayerToggleSneakEvent e) {
        if(e.getPlayer().getWorld().getName().equals(configReader.getWorld())) return; /* Thought this would be a useful feature since KeaGames would bug out with it*/
        if(!e.getPlayer().isSneaking()) {
            ServerWeather weather = DynamicWeather.getInst().getWeather();
            ActionBar actionBar = new ActionBar(e.getPlayer(), "§bServer Temp: " + weather.getTemperature() + "°C §8| §aBody Temp: " + players.get(e.getPlayer()).getBodyTemperature() + "°C");
            actionBar.runTaskTimer(DynamicWeather.getInst(), 0, 10);
        }
    }


}
