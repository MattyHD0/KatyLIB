package me.mattyhd0.katylib;

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

    public void removeSupportedPlugin(String plugin){
        supportedPlugins.remove(plugin);
    }

    public boolean hasSupport(String plugin){
        return supportedPlugins.contains(plugin);
    }

}
