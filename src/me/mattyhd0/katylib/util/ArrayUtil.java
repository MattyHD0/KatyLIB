package me.mattyhd0.katylib.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static String join(String[] array, String character){

        StringBuilder builder = new StringBuilder();

        for(String string: array){

            builder.append(string+character);

        }

        String finalString = builder.toString();

        if(finalString.length() > 1){
            return finalString.substring(0, finalString.length()-1);
        }
        return finalString;

    }

    public static String join(List<String> list, String character){

        return join((String[]) list.toArray(), character);

    }

    public static List<String> coloredList(List<String> stringList){

        List<String> coloredList = new ArrayList<>();
        for(String line: stringList){
            coloredList.add(StringUtil.color(line));
        }
        return coloredList;

    }

    public static List<String> replaceAll(List<String> list, String regex, String replacement){
        List<String> finalList = new ArrayList<>();

        list.forEach(text ->{
            finalList.add(text.replaceAll(regex, replacement));
        });

        return finalList;
    }

}
