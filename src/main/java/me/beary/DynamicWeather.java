package me.beary;

import lombok.Getter;
import lombok.Setter;
import me.beary.managers.Registerer;
import me.beary.weather.ServerWeather;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class DynamicWeather extends JavaPlugin {

    @Getter
    private static DynamicWeather inst;
    private final Registerer registerer = new Registerer();
    @Setter
    private ServerWeather weather;

    // TODO Change the rain/sun status to the weather-address
    // TODO Make temperature affect player
    // TODO Set time to the relevant time

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();
        registerer.register();
    }


}
