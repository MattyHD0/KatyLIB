package me.mattyhd0.katylib.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class InventoryUtil {

    public static void safeGive(Player player, ItemStack itemStack){

        ConsoleUtil.debug(player.getInventory().getSize()+"");

        if(!Arrays.asList(player.getInventory().getContents()).contains(null)){

            player.getWorld().dropItem(player.getLocation(), itemStack);

        } else {

            player.getInventory().addItem(itemStack);

        }

    }

}
