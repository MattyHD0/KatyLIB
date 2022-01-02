package me.mattyhd0.katylib.builders.gui;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuiListener implements Listener {

    private Plugin plugin;

    public GuiListener(Plugin plugin){
        this.plugin = plugin;
    }


    public static Map<Player, GuiBuilder> playersGui = new HashMap<>();

    public static void setPlayerOpenedGui(Player player, GuiBuilder builder){
        playersGui.put(player, builder);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if(playersGui.containsKey(player)){

            event.setCancelled(true);

            int slot = event.getSlot();
            List<GuiClickAction> actions = playersGui.get(player).clickActions.get(slot);
            Inventory clickedInventory = event.getClickedInventory();

            if(clickedInventory != null && clickedInventory != player.getInventory() && actions != null) {

                for(GuiClickAction action: actions){

                    if(action != null) action.onClick(event);

                }

            }


        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){

        Player player = (Player) event.getPlayer();
        playersGui.remove(player);
        /*
        if(playersGui.containsKey(player)) {
            new BukkitRunnable() {

                @Override
                public void run() {

                    playersGui.remove(player);

                }

            }.runTaskLater(plugin, 1L);
        }

         */

    }

}
