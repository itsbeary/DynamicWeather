package me.beary.weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import lombok.Getter;
import lombok.Setter;
import me.beary.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Getter
@Setter
public class ServerWeather {

    /*
     *
     * Too-Cold = 5c
     * Too-Hot = 30c
     *
     *     * */

    ConfigManager configReader = new ConfigManager();

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
            this.temperature = returnObject("$.currentConditions.temp");
            this.conditions = returnObject("$.currentConditions.conditions");
            this.world = Bukkit.getWorld(configReader.getWorld());

            world.setStorm(isRaining());


        }
    }

    public String returnObject(String grab) {
        if (apikey == null || apikey.isEmpty() | apikey.equals("")) {
            Bukkit.getLogger().warning("Could not create Weather Connection - Invalid Api-Key!");
        } else {
            try {
                URL url = new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "?unitGroup=metric&key=" + apikey + "&contentType=json");
                url.openConnection().connect();

                JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) url.openConnection().getContent()));
                Configuration conf = Configuration.builder().jsonProvider(new GsonJsonProvider()).build();

                JsonPrimitive obj = JsonPath.using(conf).parse(root).read(grab);

                return obj.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

    public boolean isRaining() {
        if (conditions.contains("Rain")) {
            return true;
        }
        return false;
    }

}
