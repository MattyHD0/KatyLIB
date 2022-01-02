package me.mattyhd0.katylib.builders.gui.clickactions;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import me.mattyhd0.katylib.util.StringUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;
import java.util.List;

public class SendMessageAction implements GuiClickAction {

    public String message;
    public List<InventoryAction> validActions;

    public SendMessageAction(String message, InventoryAction... validActions){
        this.message = message;
        this.validActions = Arrays.asList(validActions);
    }

    @Override
    public void onClick(InventoryClickEvent event) {

        if(validActions.size() < 1 || validActions.contains(event.getAction())) {

            Player player = (Player) event.getWhoClicked();
            player.sendMessage(StringUtil.color(message));

        }

    }
}
