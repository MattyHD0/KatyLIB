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

    public static String bukkitGradient(String text, java.awt.Color gradientStart, java.awt.Color gradientEnd){

        int r1 = gradientStart.getRed(); int r2 = gradientEnd.getRed();
        int g1 = gradientStart.getGreen(); int g2 = gradientEnd.getGreen();
        int b1 = gradientStart.getBlue(); int b2 = gradientEnd.getBlue();

        int rMath = (r1+r2/2)/text.length(); int rMath2 = (r2-r1)/text.length();
        int gMath = (g1+g2/2)/text.length(); int gMath2 = (g2-g1)/text.length();
        int bMath = (b1+b2/2)/text.length(); int bMath2 = (b2-b1)/text.length();

        String coloredText = "";

        for(int i = 1; i < text.length()+1; i++){

            int r = r1 > r2 ? rMath * i : r2-(rMath2)*i;
            int g = g1 > g2 ? gMath * i : g2-(gMath2)*i;
            int b = b1 > b2 ? bMath * i : b2-(bMath2)*i;

            coloredText = coloredText + net.md_5.bungee.api.ChatColor.of(new Color(r, g, b)) + text.charAt(i-1);

        }

        return coloredText;
    }

    public static void main(String[] args){

        System.out.println(bukkitGradient("mi text",
                new Color(0, 255, 0),
                new Color(255, 0, 0)
        ));

    }

    public static String getRandomString(String characters, int length){

        String[] chars = characters.split("");
        String text = "";

        for(int i = 0; i < length+1; i++){

            double c = Math.random()*(chars.length-1);
            text = text+chars[(int)Math.round(c)];

        }

        return text;

    }

}
