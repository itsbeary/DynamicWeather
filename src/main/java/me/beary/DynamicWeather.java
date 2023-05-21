package me.beary;

import lombok.Getter;
import lombok.Setter;
import me.beary.managers.ConfigManager;
import me.beary.managers.Registerer;
import me.beary.weather.ServerWeather;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class DynamicWeather extends JavaPlugin {

    @Getter
    private static DynamicWeather inst;
    private final Registerer registerer = new Registerer();
    private ConfigManager configManager;
    @Setter
    private ServerWeather weather;

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
        registerer.register();
        this.configManager = new ConfigManager();
        this.weather = new ServerWeather(DynamicWeather.getInst().getConfig().getString("api-key"), DynamicWeather.getInst().getConfig().getString("weather-address"));

    }


}
