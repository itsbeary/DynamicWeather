package me.beary.weather;

import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;
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

    private double temperature;
    private String conditions;

    public ServerWeather(String apikey, String city) {
        this.apikey = apikey;
        this.city = city;
        if (apikey == null || apikey.isEmpty() | apikey.equals("")) {
            Bukkit.getLogger().warning("Could not create Weather Connection - Invalid Api-Key!");
            return;
        }
        this.temperature = Double.parseDouble((String) getInfo(this,"$.currentConditions.temp"));
        this.conditions = (String) getInfo(this,"$.currentConditions.conditions");
        this.world = Bukkit.getWorld(DynamicWeather.getInst().getConfigManager().getWorld());

        if(world != null && DynamicWeather.getInst().getConfigManager().isUseTrueWeather())
            world.setStorm(conditions.contains("Rain"));

    }

}
