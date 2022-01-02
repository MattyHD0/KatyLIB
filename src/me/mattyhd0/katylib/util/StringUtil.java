package me.mattyhd0.katylib.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static final String ES_LETTERS = "abcdefghijklmnñlopqrstuvwxyz";
    public static final String EN_LETTERS = "abcdefghijklmnlopqrstuvwxyz";

    public static String color(String text){

        Pattern pattern = Pattern.compile("(&#|#)[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(text);

        if(text.length() > 0){

            while (matcher.find()) {

                String color = text.substring(matcher.start(), matcher.end());

                try {
                    text = text.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
                } catch (NoSuchMethodError e){
                    text = text.replace(color, "");
                }

                matcher = pattern.matcher(text);

            }

        }

        return ChatColor.translateAlternateColorCodes('&', text);

    }

    public static String legacyColor(String text){

        return ChatColor.translateAlternateColorCodes('&', text);

    }

    public static String getItemName(ItemStack itemStack){

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta != null && itemMeta.getDisplayName() != null){
            return itemStack.getItemMeta().getDisplayName();
        } else {
            return capitalize(itemStack.getType().toString());
        }
    }

    public static String capitalize(String string){

        //Divide la id EJEMPLO: DIAMOND_SWORD en el array {"DIAMOND", "SWORD"}
        String[] strings = string.split("_");
        String finalString = "";

        //Transforma el array {"DIAMOND", "SWORD"} en el String "Diamond Sword "
        for(String str: strings){
            str = str.toLowerCase();
            str = str.replaceFirst(Character.toString(str.charAt(0)), Character.toString(str.charAt(0)).toUpperCase());
            finalString = finalString+str+" ";
        }

        //Elimina el " " (espacio) al final del texto si este existe
        if(finalString.charAt(finalString.length()-1) == ' ') finalString = finalString.substring(0, finalString.length()-1);

        return finalString;

    }

    public static String bukkitColorFade(String text, String fadeIn, String fadeOut){

        Color c1 = net.md_5.bungee.api.ChatColor.of(fadeIn).getColor();
        Color c2 = net.md_5.bungee.api.ChatColor.of(fadeOut).getColor();

        return "NOT WORKING, SORRY :(";
    }

    public static String getRandomString(String characters, int length){

        String[] chars = characters.split("");
        String text = "";

        for(int i = 0; i < length; i++){

            double c = Math.random()*(chars.length-1);
            text = text+chars[(int)Math.round(c)];

        }

        return text;

    }

}
