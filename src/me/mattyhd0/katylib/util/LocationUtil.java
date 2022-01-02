package me.mattyhd0.katylib.util;

import org.bukkit.Location;

public class LocationUtil {


    public static boolean locationIsInZone(Location location, Location position1, Location position2){

        int locationX = (int) location.getX();
        int locationY = (int) location.getY();
        int locationZ = (int) location.getZ();

        int position1X = (int) position1.getX();
        int position1Y = (int) position1.getY();
        int position1Z = (int) position1.getZ();

        int position2X = (int) position2.getX();
        int position2Y = (int) position2.getY();
        int position2Z = (int) position2.getZ();

        if(position2X > position1X){
            int temp = position1X;
            position1X = position2X;
            position2X = temp;
        }

        if(position2Y > position1Y){
            int temp = position1Y;
            position1Y = position2Y;
            position2Y = temp;
        }

        if(position2Z > position1Z){
            int temp = position1Z;
            position1Z = position2Z;
            position2Z = temp;
        }

        return (
                (locationX <= position1X  && locationX >= position2X) &&
                        (locationY <= position1Y && locationY >= position2Y) &&
                        (locationZ <= position1Z && locationZ >= position2Z)
        );

    }

    public static Location getCenterFrom(Location position1, Location position2){

        int position1X = (int) position1.getX();
        int position1Y = (int) position1.getY();
        int position1Z = (int) position1.getZ();

        int position2X = (int) position2.getX();
        int position2Y = (int) position2.getY();
        int position2Z = (int) position2.getZ();

        if(position2X > position1X){
            int temp = position1X;
            position1X = position2X;
            position2X = temp;
        }

        if(position2Y > position1Y){
            int temp = position1Y;
            position1Y = position2Y;
            position2Y = temp;
        }

        if(position2Z > position1Z){
            int temp = position1Z;
            position1Z = position2Z;
            position2Z = temp;
        }

        return new Location(position1.getWorld(), (position1X+position2X)/2, (position1Y+position2Y)/2, (position1Z+position2Z)/2);

    }

}
