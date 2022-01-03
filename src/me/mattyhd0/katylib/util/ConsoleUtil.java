package me.mattyhd0.katylib.util;

import me.mattyhd0.katylib.KatyLIBPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ConsoleUtil {

    public static void error(String message){

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.RED + "["+ KatyLIBPlugin.INSTANCE.getDescription().getName()+"] ERROR: " + message
        );

    }

    public static void debug(String message){

        Bukkit.getConsoleSender().sendMessage(
                "["+ KatyLIBPlugin.INSTANCE.getDescription().getName() +"] DEBUG: " + message
        );

    }

    public static void send(String message){

        Bukkit.getConsoleSender().sendMessage(
                StringUtil.color("["+ KatyLIBPlugin.INSTANCE.getDescription().getName()+"] " + message)
        );

    }

}
