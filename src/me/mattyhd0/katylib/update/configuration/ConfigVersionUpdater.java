package me.mattyhd0.katylib.update.configuration;

import me.mattyhd0.katylib.files.YMLFile;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class ConfigVersionUpdater {

    YMLFile ymlFile;
    FileConfiguration fileConfiguration;
    List<ConfigVersion> configVersions = new ArrayList<>();

    public ConfigVersionUpdater(YMLFile ymlFile){
        this.ymlFile = ymlFile;
        this.fileConfiguration = ymlFile.get();
    }

    public void addConfigVersion(ConfigVersion... configVersion){
        configVersions.addAll(Arrays.asList(configVersion));
    }

    @Deprecated
    public void legacyUpdate(){

        for(int i = 0; i < configVersions.size(); i++){

            int configVer = fileConfiguration.getInt("config-version");

            if(configVer == i){

                fileConfiguration.set("config-version", configVer+1);
                ConfigVersion configVersion = configVersions.get(i);

                for(Map.Entry<String, String> entry: configVersion.strings.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, Integer> entry: configVersion.ints.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, Long> entry: configVersion.longs.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, Byte> entry: configVersion.bytes.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, Double> entry: configVersion.doubles.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, Float> entry: configVersion.floats.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                //Lists

                for(Map.Entry<String, List<String>> entry: configVersion.stringsList.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, List<Integer>> entry: configVersion.intsList.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, List<Long>> entry: configVersion.longsList.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, List<Byte>> entry: configVersion.bytesList.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String, List<Double>> entry: configVersion.doublesList.entrySet()){
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

                for(Map.Entry<String,List<Float>> entry: configVersion.floatsList.entrySet()) {
                    if(!fileConfiguration.contains(entry.getKey())) fileConfiguration.set(entry.getKey(), entry.getValue());
                }

            }

            ymlFile.save();

        }

    }

    public void update(){

        for(int i = 0; i < configVersions.size(); i++){

            int configVer = fileConfiguration.getInt("config-version");

            if(configVer == i){

                fileConfiguration.set("config-version", configVer+1);
                ConfigVersion configVersion = configVersions.get(i);

                for(Map.Entry<String, Object> entry: configVersion.objectMap.entrySet()){

                    String key = entry.getKey();
                    Object value = entry.getValue();

                    if(!fileConfiguration.contains(key)) fileConfiguration.set(key, value);
                }

            }

            ymlFile.save();

        }

    }

}
