package me.mattyhd0.katylib.files;

import me.mattyhd0.katylib.KatyLIB;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
public class YMLFile {

    public String fileName;
    public File file;
    public Plugin plugin;
    public FileConfiguration fileConfiguration;
    
    public YMLFile(String fileName, @Nullable Plugin plugin) {
        if(plugin == null) this.plugin = KatyLIB.PLUGIN;
        this.plugin = plugin;

        this.fileName = fileName;
        this.file = new File(plugin.getDataFolder(), this.fileName);
        this.check();
    }
    
    public FileConfiguration get() {
        return this.fileConfiguration;
    }
    
    public void check() {
        if (!this.file.exists()) {
            this.createFile();
        }
        this.loadFile();
        /*
        if(!loadedFiles.contains(fileName)) {
            this.loadFile();
            loadedFiles.add(fileName);
        }

         */
    }
    
    public void createFile() {
        this.file.getParentFile().mkdirs();
        plugin.saveResource(this.fileName, false);
    }
    
    public void loadFile() {
        this.fileConfiguration = new YamlConfiguration();
        try {
            this.fileConfiguration.load(this.file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            this.get().save(this.file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
