package me.beary.commands;

import me.beary.DynamicWeather;
import me.beary.weather.impl.ServerWeather;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DynamicWeatherCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !sender.hasPermission("dynamicweather.commands")) return false;
        sender.sendMessage(command(args));
        return false;
    }

    public String command(String[] args) {
        String message = "§3§lDynamicWeather §8| §b";
        if(args.length == 0) return message + "Not enough arguments!";

        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("reload")) {
                DynamicWeather.getInst().reloadConfig(); /* Reload config before setting new weather */
                DynamicWeather.getInst().setWeather(new ServerWeather(DynamicWeather.getInst().getConfig().getString("api-key"), DynamicWeather.getInst().getConfig().getString("weather-address")));
                return message + "Reloaded plugin!";
            } else if(args[0].equals("changeweather")) {
                if(DynamicWeather.getInst().getWeather().isChangeWeather()) {
                    DynamicWeather.getInst().getWeather().setChangeWeather(false);
                    return "Cannot change weather anymore!";
                } else {
                    DynamicWeather.getInst().getWeather().setChangeWeather(true);
                    return "Can change weather now!";
                }
            }
        }

        return "§cError in running command!";
    }

}
