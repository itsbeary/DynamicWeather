package me.beary.weather.impl;

import lombok.Getter;
import lombok.Setter;
import me.beary.DynamicWeather;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

@Getter @Setter
public class WeatherPlayer {

    private Player bukkitPlayer;
    private UUID uniqueID;

    private int bodyTemperature;

    public WeatherPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.uniqueID = bukkitPlayer.getUniqueId();

        this.bodyTemperature = Integer.parseInt(DynamicWeather.getInst().getWeather().getTemperature()); /* sets body temperature to server temperature by default*/
    }


}
