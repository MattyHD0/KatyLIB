package me.mattyhd0.katylib.web.api.spigot;

import com.google.gson.Gson;
import me.mattyhd0.katylib.web.Web;

public class SpigotAPI {

    public static SpigotResource getSpigotResource(int id){

        String response = Web.getStringFromUrl("https://api.spigotmc.org/simple/0.2/index.php?action=getResource&id="+id);
        Gson gson = new Gson();
        return gson.fromJson(response, SpigotResource.class);

    }

}
