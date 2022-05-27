package me.weirdestboi.freezzze;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeListCommand implements CommandExecutor {


    Freezzze plugin;

    public FreezeListCommand(Freezzze plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        sender.sendMessage("§9§m------------------------------------------------");
        sender.sendMessage("§fThere are §e" + String.valueOf(plugin.FrozenPlayers.size()) + "§f Players Currently §aFrozen:");
        sender.sendMessage("§9§m------------------------------------------------");
        return true;
    }
}
