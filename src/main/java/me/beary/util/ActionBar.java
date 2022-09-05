package me.beary.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar extends BukkitRunnable {

    private Player player;
    private String message;

    public ActionBar(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    @Override
    public void run() {
        if(!player.isOnline() || !player.isSneaking()) cancel();
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

    }
}
