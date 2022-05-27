package me.weirdestboi.freezzze;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import me.weirdestboi.freezzze.FreezeCommand;
import me.weirdestboi.freezzze.FreezeListener;

import java.util.ArrayList;

public final class Freezzze extends JavaPlugin {
    public ArrayList<Player> FrozenPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getCommand("freezelist").setExecutor(new FreezeListCommand(this));
        getServer().getPluginManager().registerEvents(new FreezeListener(this), this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("freezereload")) {
            reloadConfig();
            sender.sendMessage(this.getConfig().getString("ReloadMessage").replace("&", "§"));
        }

        return true;
    }
}
