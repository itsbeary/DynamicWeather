package me.beary.managers;


import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;

@Getter
@Setter
public class ConfigManager {

    private String apikey;
    private String weatheraddress;
    private boolean usetrueweather;
    private boolean usetruetemperature;
    private boolean usetruetime;
    private String world;

    public ConfigManager() {
        this.apikey = DynamicWeather.getInst().getConfig().getString("api-key");
        this.weatheraddress = DynamicWeather.getInst().getConfig().getString("weather-address");
        this.usetrueweather = DynamicWeather.getInst().getConfig().getBoolean("use-true-weather");
        this.usetruetemperature = DynamicWeather.getInst().getConfig().getBoolean("use-true-temperature");
        this.usetruetime = DynamicWeather.getInst().getConfig().getBoolean("use-true-time");
        this.world = DynamicWeather.getInst().getConfig().getString("weather-worldname");
    }

}
