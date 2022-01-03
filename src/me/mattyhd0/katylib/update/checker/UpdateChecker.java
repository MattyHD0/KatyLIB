package me.mattyhd0.katylib.update.checker;

import com.sun.istack.internal.NotNull;
import me.mattyhd0.katylib.web.api.spigot.SpigotAPI;
import me.mattyhd0.katylib.web.api.spigot.SpigotResource;
import org.bukkit.plugin.Plugin;

public class UpdateChecker {

    private String version;
    private SpigotResource spigotResource;
    private String latestVersion;

    public UpdateChecker(@NotNull Plugin plugin, int spigotResourceId){

        version = plugin.getDescription().getVersion();

        spigotResource = SpigotAPI.getSpigotResource(spigotResourceId);
        latestVersion = spigotResource.getCurrentVersion();

    }

    public boolean isRunningLatestVersion() {
        return version.equals(latestVersion);
    }

    public String getVersion() {
        return version;
    }
    
    public String getLatestVersion() {
        return latestVersion;
    }

    public SpigotResource getSpigotResource() {
        return spigotResource;
    }

    public boolean requestIsValid() {
        return spigotResource != null;
    }

}
