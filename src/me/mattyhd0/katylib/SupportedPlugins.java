package me.mattyhd0.katylib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SupportedPlugins {

    List<String> supportedPlugins = new ArrayList<>();

    public SupportedPlugins(){

    }

    public void addSupportedPlugin(String plugin){
        supportedPlugins.add(plugin);
    }

    public void addIfHasPlugin(String plugin){

        Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(plugin);
        if(pl != null && pl.isEnabled()) supportedPlugins.add(plugin);

    }


    public void removeSupportedPlugin(String plugin){
        supportedPlugins.remove(plugin);
    }

    public boolean hasSupport(String plugin){
        return supportedPlugins.contains(plugin);
    }

}
