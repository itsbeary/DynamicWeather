package me.beary.util;


import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;

@Getter @Setter
public class ConfigReader {

    private String apikey;
    private String weatheraddress;
    private boolean usetrueweather;
    private boolean usetruetemperature;
    private boolean usetruetime;
    private String world;

    public ConfigReader() {
        this.apikey = DynamicWeather.getInst().getConfig().getString("api-key");
        this.weatheraddress = DynamicWeather.getInst().getConfig().getString("weather-address");
        this.usetrueweather = DynamicWeather.getInst().getConfig().getBoolean("use-true-weather");
        this.usetruetemperature= DynamicWeather.getInst().getConfig().getBoolean("use-true-temperature");
        this.usetruetime = DynamicWeather.getInst().getConfig().getBoolean("use-true-time");
        this.world = DynamicWeather.getInst().getConfig().getString("weather-worldname");
    }

    public void saveToConfig() {
        DynamicWeather.getInst().getConfig().set("apikey", apikey);
        DynamicWeather.getInst().getConfig().set("weather-address", weatheraddress);
        DynamicWeather.getInst().getConfig().set("use-true-weather", usetrueweather);
        DynamicWeather.getInst().getConfig().set("use-true-temperature", usetruetemperature);
        DynamicWeather.getInst().getConfig().set("use-true-time", usetruetime);
        DynamicWeather.getInst().getConfig().set("weather-worldname", world);
        DynamicWeather.getInst().saveConfig();
    }

}
