package me.mattyhd0.katylib.update.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigVersion {

    public Map<String, Object> objectMap = new HashMap<>();

    public Map<String, String> strings = new HashMap<>();
    public Map<String, Integer> ints = new HashMap<>();
    public Map<String, Long> longs = new HashMap<>();
    public Map<String, Byte> bytes = new HashMap<>();
    public Map<String, Double> doubles = new HashMap<>();
    public Map<String, Float> floats = new HashMap<>();

    public Map<String, List<String>> stringsList = new HashMap<>();
    public Map<String, List<Integer>> intsList = new HashMap<>();
    public Map<String, List<Long>> longsList = new HashMap<>();
    public Map<String, List<Byte>> bytesList = new HashMap<>();
    public Map<String, List<Double>> doublesList = new HashMap<>();
    public Map<String, List<Float>> floatsList = new HashMap<>();

    public ConfigVersion(){
    }

    public ConfigVersion set(String key, Object object){
        objectMap.put(key, object);
        return this;
    }

    @Deprecated
    public ConfigVersion addString(String key, String string){
        strings.put(key, string);
        return this;
    }

    @Deprecated
    public ConfigVersion addInt(String key, int number){
        ints.put(key, number);
        return this;
    }

    @Deprecated
    public ConfigVersion addLong(String key, long number){
        longs.put(key, number);
        return this;
    }

    @Deprecated
    public ConfigVersion addByte(String key, byte number){
        bytes.put(key, number);
        return this;
    }

    @Deprecated
    public ConfigVersion addDouble(String key, double number){
        doubles.put(key, number);
        return this;
    }

    @Deprecated
    public ConfigVersion addFloat(String key, float number){
        floats.put(key, number);
        return this;
    }

    @Deprecated
    public ConfigVersion addStringList(String key, List<String> stringList){
        stringsList.put(key, stringList);
        return this;
    }

    @Deprecated
    public ConfigVersion addIntList(String key, List<Integer> numberList){
        intsList.put(key, numberList);
        return this;
    }

    @Deprecated
    public ConfigVersion addLongList(String key, List<Long> numberList){
        longsList.put(key, numberList);
        return this;
    }

    @Deprecated
    public ConfigVersion addByteList(String key, List<Byte> numberList){
        bytesList.put(key, numberList);
        return this;
    }

    @Deprecated
    public ConfigVersion addDoubleList(String key, List<Double> numberList){
        doublesList.put(key, numberList);
        return this;
    }

    @Deprecated
    public ConfigVersion addFloatList(String key, List<Float> numberList){
        floatsList.put(key, numberList);
        return this;
    }

}
