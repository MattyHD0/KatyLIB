package me.mattyhd0.katylib.util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EntityUtil {

    public static void purgeAllEntities(){
        for(World world: Bukkit.getServer().getWorlds()){

            for(Entity entity: world.getEntities()){

                if(!(entity instanceof Player)) entity.remove();

            }

        }
    }

}
