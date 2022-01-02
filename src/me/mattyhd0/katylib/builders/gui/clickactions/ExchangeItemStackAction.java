package me.mattyhd0.katylib.builders.gui.clickactions;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import me.mattyhd0.katylib.util.InventoryUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ExchangeItemStackAction implements GuiClickAction {

    public ItemStack needs;
    public ItemStack receive;
    public List<InventoryAction> validActions;

    public ExchangeItemStackAction(ItemStack needs, ItemStack receive, InventoryAction... validActions){
        this.needs = needs;
        this.receive = receive;
        this.validActions = Arrays.asList(validActions);
    }

    @Override
    public void onClick(InventoryClickEvent event) {

        if(validActions.size() < 1 || validActions.contains(event.getAction())) {

            Player player = (Player) event.getWhoClicked();

            for(int i = 0; i < 9*4; i++){

                ItemStack itemStack = player.getInventory().getContents()[i];

                if(itemStack != null) {

                    ItemStack isCopy = itemStack.clone();
                    isCopy.setAmount(needs.getAmount());

                    if(isCopy.equals(needs)){

                        if(itemStack.getAmount() > needs.getAmount()){
                            itemStack.setAmount(itemStack.getAmount() - needs.getAmount());
                            InventoryUtil.safeGive(player, receive);
                            break;
                        } else if (itemStack.getAmount() == needs.getAmount()){
                            player.getInventory().setItem(i, new ItemStack(Material.AIR));
                            InventoryUtil.safeGive(player, receive);
                            break;
                        }

                    }

                }

            }

        }

    }

}
