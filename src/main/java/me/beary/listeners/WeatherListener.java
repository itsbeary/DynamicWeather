package me.beary.listeners;

import me.beary.DynamicWeather;
import me.beary.managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {

    ConfigManager configReader = new ConfigManager();

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (!e.getWorld().getName().equals(configReader.getWorld())) return;
        if (DynamicWeather.getInst().getWeather().isChangeWeather()) return;
        e.setCancelled(true); /* Cancels the weather being changed from minecraft*/
    }

}
