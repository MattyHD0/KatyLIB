package me.mattyhd0.katylib;

import me.mattyhd0.katylib.builders.gui.GuiListener;
import me.mattyhd0.katylib.files.YMLFile;
import me.mattyhd0.katylib.scoreboard.ScoreboardListener;
import me.mattyhd0.katylib.test.TestCommand;
import me.mattyhd0.katylib.update.configuration.ConfigVersion;
import me.mattyhd0.katylib.update.configuration.ConfigVersionUpdater;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class KatyLIBPlugin extends JavaPlugin {

    public static Plugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        getServer().getPluginManager().registerEvents(new GuiListener(this), this);
        getServer().getPluginManager().registerEvents(new ScoreboardListener(), this);

        getServer().getPluginCommand("kgui").setExecutor(new TestCommand());

        ConfigVersionUpdater configVersionUpdater = new ConfigVersionUpdater(new YMLFile("config.yml", this));

        String[] test = {"Just", "a", "test"};

        configVersionUpdater.addConfigVersion(
                new ConfigVersion()
                        .set("text", "just a text")
                        .set("reason","ConfigVersion and ConfigVersionUpdater test"),
                new ConfigVersion()
                        .set("integer", 2),
                new ConfigVersion()
                        .set("test-list", Arrays.asList(test))
        );
    }

    @Override
    public void onDisable() {

    }
}
