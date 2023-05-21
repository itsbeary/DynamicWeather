package me.beary.commands;

import me.beary.DynamicWeather;
import me.beary.util.ChatUtils;
import me.beary.weather.ServerWeather;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DynamicWeatherCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || !sender.hasPermission("dynamicweather.commands")) return false;
        sender.sendMessage(ChatUtils.prefixFormat(command(args)));
        return false;
    }

    public String command(String[] args) {
        if (args.length != 1)
            return "<reload|changeweather>";

        switch (args[0]) {
            case "reload" -> {
                DynamicWeather.getInst().reloadConfig();
                DynamicWeather.getInst().setWeather(new ServerWeather(DynamicWeather.getInst().getConfig().getString("api-key"), DynamicWeather.getInst().getConfig().getString("weather-address")));
                return "Reloaded plugin!";
            }
            case "changeweather" -> {
                DynamicWeather.getInst().getWeather().setChangeWeather(!DynamicWeather.getInst().getWeather().isChangeWeather());
                return (DynamicWeather.getInst().getWeather().isChangeWeather() ? "Cannot change weather anymore!" : "Can change weather now");
            }
        }
        return "";
    }

}
