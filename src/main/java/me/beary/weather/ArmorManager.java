package me.beary.weather;

import me.beary.DynamicWeather;
import me.beary.weather.impl.ServerWeather;
import me.beary.weather.impl.WeatherPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ArmorManager {

    /*
    *
    * Class to convert any armor to add temperature
    *
    * */

    /*
    * Air & Chainmail = 1 (body temperature should atleast be above the server)
    * Any Leather Armour = +6 - Just a buff for leather armour really
    * Any Iron & Gold Armour = +3
    * Any Diamond Armour = +2
    * Any Netherrite Armour + 1.5
    *
    * */


    public void armorManager(WeatherPlayer weatherPlayer) {
        ServerWeather serverWeather = DynamicWeather.getInst().getWeather();


    }

}
