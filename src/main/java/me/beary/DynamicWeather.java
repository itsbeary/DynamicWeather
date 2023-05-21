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
    private final ConfigManager configManager = new ConfigManager();
    @Setter
    private ServerWeather weather;

    // TODO Make temperature affect player
    // TODO Set time to the relevant time

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
        registerer.register();
    }


}
