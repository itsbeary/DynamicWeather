package me.beary.managers;

import me.beary.DynamicWeather;
import me.beary.commands.DynamicWeatherCommand;
import me.beary.listeners.PlayerListener;
import me.beary.listeners.WeatherListener;
import me.beary.weather.ServerWeather;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Registerer {

    public void register() {
        startWeatherUpdate();
        registerListeners(new PlayerListener(), new WeatherListener());

        DynamicWeather.getInst().getCommand("dynamicweather").setExecutor(new DynamicWeatherCommand());
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners)
            Bukkit.getServer().getPluginManager().registerEvents(listener, DynamicWeather.getInst());
    }

    private void startWeatherUpdate() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(DynamicWeather.getInst(), () -> {
            DynamicWeather.getInst().setWeather(new ServerWeather(DynamicWeather.getInst().getConfig().getString("api-key"), DynamicWeather.getInst().getConfig().getString("weather-address")));
        }, 0, 72000);
    }

}
