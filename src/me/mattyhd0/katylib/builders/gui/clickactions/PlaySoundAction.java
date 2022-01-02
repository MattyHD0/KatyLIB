package me.mattyhd0.katylib.builders.gui.clickactions;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;
import java.util.List;

public class PlaySoundAction implements GuiClickAction {

    public Sound sound;
    public float pitch;
    public float yaw;
    public List<InventoryAction> validActions;

    public PlaySoundAction(Sound sound, float pitch, float yaw, InventoryAction... validActions){

        this.sound = sound;
        this.pitch = pitch;
        this.yaw = yaw;
        this.validActions = Arrays.asList(validActions);

    }

    @Override
    public void onClick(InventoryClickEvent event) {

        if(validActions.size() < 1 || validActions.contains(event.getAction())){

            Player player = (Player) event.getWhoClicked();
            player.playSound(player.getLocation(), sound, pitch, yaw);

        }

    }
}
