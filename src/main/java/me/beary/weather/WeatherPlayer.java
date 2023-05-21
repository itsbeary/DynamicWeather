package me.beary.weather;

import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;
import me.beary.managers.ArmorManager;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class WeatherPlayer {

    ArmorManager armorManager = new ArmorManager();
    private Player bukkitPlayer;
    private UUID uniqueID;
    private double temperature;


    public WeatherPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.uniqueID = bukkitPlayer.getUniqueId();

        this.temperature = Double.parseDouble(DynamicWeather.getInst().getWeather().getTemperature()); /* sets body temperature to server temperature by default*/
    }


}
