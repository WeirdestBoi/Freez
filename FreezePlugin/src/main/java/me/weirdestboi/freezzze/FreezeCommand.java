package me.weirdestboi.freezzze;

import com.connorlinfoot.titleapi.TitleAPI;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class FreezeCommand implements CommandExecutor {


    Freezzze plugin;

    public FreezeCommand(Freezzze plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (plugin.FrozenPlayers.contains(target)) {
                plugin.FrozenPlayers.remove(target);
                target.sendMessage(plugin.getConfig().getString("GotUnFrozenMessage").replace("&", "§"));
                sender.sendMessage("§fYou just unFroze §a" + target.getName());
                System.out.println(ChatColor.GREEN + sender.getName() + "§fJust froze§e" + target.getName());
                TitleAPI.sendTitle(target, 10, 40, 5, plugin.getConfig().getString("unfrozentitle").replace("&", "§"), plugin.getConfig().getString("unfrozensubtitle").replace("&", "§"));
            } else {
                plugin.FrozenPlayers.add(target);
                target.sendMessage(plugin.getConfig().getString("GotFrozenMessage").replace("&", "§"));
                sender.sendMessage("§fYou just Froze §a" + target.getName());
                System.out.println(ChatColor.GREEN + sender.getName() + "§fJust Froze§e" + target.getName());
                TitleAPI.sendTitle(target, 10, 40, 5, plugin.getConfig().getString("frozentitle").replace("&", "§"), plugin.getConfig().getString("frozensubtitle").replace("&", "§"));
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("DefineAPlayerMessage").replace("&", "§"));
        }

        return true;
    }
}
