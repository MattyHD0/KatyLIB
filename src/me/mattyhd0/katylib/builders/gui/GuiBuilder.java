package me.mattyhd0.katylib.builders.gui;

import me.mattyhd0.katylib.builders.gui.clickactions.api.GuiClickAction;
import me.mattyhd0.katylib.util.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class GuiBuilder {

    public String title = "";
    public GuiFillType fill = GuiFillType.BEFORE_OPEN_GUI;
    public InventoryType inventoryType;
    public byte rows;
    public Map<Integer, List<GuiClickAction>> clickActions = new HashMap<>();
    public Map<Integer, ItemStack> guiItems = new HashMap<>();

    /*
        Constructors
    */

    public GuiBuilder() {

    }

    public GuiBuilder(String title, InventoryType inventoryType){
        this.title = title;
        this.inventoryType = inventoryType;
    }

    public GuiBuilder(String title, int rows){
        this.title = title;
        this.rows = (byte) rows;
    }

    /*
        SETTERS
     */

    public GuiBuilder setTitle(String title){
        this.title = StringUtil.color(title);
        return this;
    }

    public GuiBuilder setRows(int rows){
        this.rows = (byte)rows;
        return this;
    }

    public GuiBuilder setFillType(GuiFillType fill){
        this.fill = fill;
        return this;
    }

    public GuiBuilder setGuiItem(int slot, ItemStack itemStack){
        guiItems.put(slot, itemStack);
        return this;
    }

    public GuiBuilder setGuiItem(int slot, ItemStack itemStack, GuiClickAction... actions){
        guiItems.put(slot, itemStack);
        clickActions.put(slot, Arrays.asList(actions));
        return this;
    }

    public GuiBuilder setClickAction(int slot, GuiClickAction... actions){
        clickActions.put(slot, Arrays.asList(actions));
        return this;
    }

    public GuiBuilder setInventoryType(InventoryType inventoryType){
        this.inventoryType = inventoryType;
        return this;
    }

    /*
        GETTERS
     */

    public String getTitle(){
        return title;
    }

    public byte getRows(){
        return rows;
    }

    public ItemStack getGuiItem(int slot){
        return guiItems.get(slot);
    }

    public Map<Integer, ItemStack> getGuiItems() {
        return guiItems;
    }

    public List<GuiClickAction> getClickActions(int slot){
        return clickActions.get(slot);
    }

    public Map<Integer, List<GuiClickAction>> getGuiClickActions() {
        return clickActions;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    /*
        VOIDS
     */

    private void fill(Inventory inventory, Map<Integer, ItemStack> items){

        for(Map.Entry<Integer, ItemStack> entry: guiItems.entrySet()){

            try {
                inventory.setItem(entry.getKey(), entry.getValue());
            } catch (ArrayIndexOutOfBoundsException exception){
                exception.printStackTrace();
            }

        }

    }

    public void open(Player player){

        Inventory gui = Bukkit.createInventory(null, 6*9, title);

        if(rows >= 1 && rows <= 6){
            gui = Bukkit.createInventory(null, rows*9, title);
        }

        if(inventoryType != null) {
            gui = Bukkit.createInventory(null, inventoryType, title);
        }

        if(fill == GuiFillType.BEFORE_OPEN_GUI) fill(gui, guiItems);

        player.openInventory(gui);

        if(fill == GuiFillType.AFTER_OPEN_GUI) fill(player.getOpenInventory().getTopInventory(), guiItems);

        GuiListener.setPlayerOpenedGui(player, this);

    }

}
