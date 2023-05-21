package me.beary.weather;

import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;
import org.bukkit.entity.Player;

@Getter @Setter
public class WeatherPlayer {

    private final Player player;
    private double temperature = DynamicWeather.getInst().getWeather().getTemperature();

    public WeatherPlayer(Player player) {
        this.player = player;
    }


}
