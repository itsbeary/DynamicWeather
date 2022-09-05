package me.beary;

import lombok.Getter;
import lombok.Setter;
import me.beary.commands.DynamicWeatherCommand;
import me.beary.weather.listeners.PlayerListener;
import me.beary.weather.listeners.WeatherListener;
import me.beary.weather.WeatherUpdate;
import me.beary.weather.impl.Weather;
import org.bukkit.plugin.java.JavaPlugin;

public class DynamicWeather extends JavaPlugin {

    @Getter @Setter
    private Weather weather;

    @Getter
    private static DynamicWeather inst;

    // TODO Change the rain/sun status to the weather-address
    // TODO Make temperature affect player
    // TODO Set time to the relevant time

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new WeatherListener(), this);
        //weather = new Weather(getConfig().getString("api-key"), getConfig().getString("weather-address"));

        WeatherUpdate weatherUpdate = new WeatherUpdate();
        weatherUpdate.runTaskTimer(this, 0, 72000);

        getCommand("dynamicweather").setExecutor(new DynamicWeatherCommand());
    }


}
