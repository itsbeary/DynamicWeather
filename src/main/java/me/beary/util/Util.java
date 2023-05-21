package me.beary.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import me.beary.DynamicWeather;
import me.beary.weather.ServerWeather;
import org.bukkit.Bukkit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Util {

    public static String getInfo(String json) {
        ServerWeather weather = DynamicWeather.getInst().getWeather();
        if (weather.getApikey() == null || weather.getApikey().isEmpty()) {
            Bukkit.getLogger().warning("Could not create Weather Connection - Invalid Api-Key!");
            return null;
        }
        try {
            URL url = new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + weather.getCity() + "?unitGroup=metric&key=" + weather.getApikey() + "&contentType=json");
            url.openConnection().connect();

            JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) url.openConnection().getContent()));
            Configuration conf = Configuration.builder().jsonProvider(new GsonJsonProvider()).build();

            JsonPrimitive obj = JsonPath.using(conf).parse(root).read(json);

            return obj.toString();
        } catch (Exception ignore) {}
        return null;
    }

}
