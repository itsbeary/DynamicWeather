package me.beary.weather;

import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;
import me.beary.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import static me.beary.util.Util.getInfo;

@Getter
@Setter
public class ServerWeather {
    private World world;

    private String apikey;
    private String city;

    private boolean changeWeather;

    private String temperature;
    private String conditions;

    public ServerWeather(String apikey, String city) {
        if (apikey == null || apikey.isEmpty() | apikey.equals("")) {
            Bukkit.getLogger().warning("Could not create Weather Connection - Invalid Api-Key!");
            Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("DynamicWeather"));
        } else {
            this.apikey = apikey;
            this.city = city;


            this.changeWeather = false;
            this.temperature = getInfo("$.currentConditions.temp");
            this.conditions = getInfo("$.currentConditions.conditions");
            this.world = Bukkit.getWorld(DynamicWeather.getInst().getConfigManager().getWorld());

            if(world != null)
                world.setStorm(conditions.contains("Rain"));

        }
    }

}
