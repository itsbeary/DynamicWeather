package me.beary.weather;

import me.beary.DynamicWeather;
import me.beary.util.Util;
import me.beary.weather.impl.ServerWeather;
import org.bukkit.scheduler.BukkitRunnable;

public class WeatherUpdate extends BukkitRunnable {


    @Override
    public void run() {
        DynamicWeather.getInst().setWeather(new ServerWeather(DynamicWeather.getInst().getConfig().getString("api-key"), DynamicWeather.getInst().getConfig().getString("weather-address")));
        Util.sendBoldMessageToConsole("Updating Weather Data");
    }
}
