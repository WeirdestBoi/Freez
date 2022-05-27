package me.weirdestboi.freezzze;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class FreezeListener implements Listener {

    Freezzze plugin;

    public FreezeListener(Freezzze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!plugin.getConfig().getBoolean("freezecanMove")) {
            Player player = e.getPlayer();
            if (plugin.FrozenPlayers.contains(e.getPlayer())) {
                player.teleport(e.getFrom());
                player.sendMessage(plugin.getConfig().getString("FrozenMoveMessage").replace("&", "§"));
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getConfig().getBoolean("freezecanChat")) {
            if (plugin.FrozenPlayers.contains(e.getPlayer())) {
                e.setCancelled(true);
                player.sendMessage(plugin.getConfig().getString("FrozenChatMessage").replace("&", "§"));
            }
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getConfig().getBoolean("freezecanCommand")) {
            if (plugin.FrozenPlayers.contains(e.getPlayer())) {
                e.setCancelled(true);
                player.sendMessage(plugin.getConfig().getString("FrozenCommandMessage").replace("&", "§"));
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getConfig().getBoolean("freezecanBreak")) {
            if (plugin.FrozenPlayers.contains(e.getPlayer())) {
                e.setCancelled(true);
                player.sendMessage(plugin.getConfig().getString("FrozenBreakMessage").replace("&", "§"));
            }
        }
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getConfig().getBoolean("freezecanPlace")) {
            if (plugin.FrozenPlayers.contains(e.getPlayer())) {
                e.setCancelled(true);
                player.sendMessage(plugin.getConfig().getString("FrozenPlaceMessage").replace("&", "§"));
            }
        }
    }
}
