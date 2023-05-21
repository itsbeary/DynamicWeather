package me.beary.managers;


import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;

@Getter
@Setter
public class ConfigManager {

    private String apikey;
    private String weatherAddress;
    private boolean useTrueWeather;
    private boolean useTrueTemperature;
    private boolean useTrueTime;
    private String world;

    public ConfigManager() {
        this.apikey = DynamicWeather.getInst().getConfig().getString("api-key");
        this.weatherAddress = DynamicWeather.getInst().getConfig().getString("weather-address");
        this.useTrueWeather = DynamicWeather.getInst().getConfig().getBoolean("use-true-weather");
        this.useTrueTemperature = DynamicWeather.getInst().getConfig().getBoolean("use-true-temperature");
        this.useTrueTime = DynamicWeather.getInst().getConfig().getBoolean("use-true-time");
        this.world = DynamicWeather.getInst().getConfig().getString("weather-worldname");
    }

}
