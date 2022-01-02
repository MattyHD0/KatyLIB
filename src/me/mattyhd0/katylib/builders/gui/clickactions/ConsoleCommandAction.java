package me.mattyhd0.katylib.builders.gui.clickactions;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;
import java.util.List;

public class ConsoleCommandAction implements GuiClickAction {

    public String command;
    public List<InventoryAction> validActions;

    public ConsoleCommandAction(String command, InventoryAction... validActions){
        this.command = command;
        this.validActions = Arrays.asList(validActions);
    }

    @Override
    public void onClick(InventoryClickEvent event) {

        if(validActions.size() < 1 || validActions.contains(event.getAction())) {

            Player player = (Player) event.getWhoClicked();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

            Bukkit.getServer().dispatchCommand(
                    console,
                    command.replaceAll("%player%", player.getName())
            );

        }

    }
}
