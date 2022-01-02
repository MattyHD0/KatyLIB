package me.mattyhd0.katylib.util;

import me.mattyhd0.katylib.KatyLIB;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ConsoleUtil {

    public static void error(String message){

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.RED + "["+ KatyLIB.PLUGIN.getDescription().getName()+"] ERROR: " + message
        );

    }

    public static void debug(String message){

        Bukkit.getConsoleSender().sendMessage(
                "["+ KatyLIB.PLUGIN.getDescription().getName() +"] DEBUG: " + message
        );

    }

    public static void send(String message){

        Bukkit.getConsoleSender().sendMessage(
                StringUtil.color("["+ KatyLIB.PLUGIN.getDescription().getName()+"] " + message)
        );

    }

}
