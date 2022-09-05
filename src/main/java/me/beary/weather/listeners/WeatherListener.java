package me.beary.weather.listeners;

import me.beary.DynamicWeather;
import me.beary.util.ConfigReader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.checkerframework.checker.units.qual.C;

public class WeatherListener implements Listener {

    ConfigReader configReader = new ConfigReader();

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if(!e.getWorld().getName().equals(configReader.getWorld())) return;
        if(DynamicWeather.getInst().getWeather().isChangeWeather()) return;
        e.setCancelled(true); /* Cancels the weather being changed from minecraft*/
    }

}
