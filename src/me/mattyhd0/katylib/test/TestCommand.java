package me.mattyhd0.katylib.test;

import me.mattyhd0.katylib.KatyLIB;
import me.mattyhd0.katylib.KatyLIBPlugin;
import me.mattyhd0.katylib.builders.gui.GuiBuilder;
import me.mattyhd0.katylib.builders.gui.clickactions.*;
import me.mattyhd0.katylib.util.ItemStackUtil;
import me.mattyhd0.katylib.files.YMLFile;
import me.mattyhd0.katylib.util.StringUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] arg) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(player.hasPermission("mutil.gui")){

                // All the code :D

                YMLFile ymlFile = new YMLFile("config.yml", KatyLIBPlugin.INSTANCE);
                FileConfiguration config = ymlFile.get();

                List<Color> colorList = new ArrayList<>();

                colorList.add(new Color(255, 0, 0));
                colorList.add(new Color(255, 255, 0));
                colorList.add(new Color(0, 255, 0));
                colorList.add(new Color(0, 255, 255));
                colorList.add(new Color(0, 0, 255));
                colorList.add(new Color(255, 0, 255));



                String title = StringUtil.bukkitGradient("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||",
                        colorList
                );

                GuiBuilder builder = new GuiBuilder()
                        .setTitle(title)
                        .setRows(1)
                        //.setInventoryType(InventoryType.HOPPER)
                        //.setGuiItem(0, ItemStackUtil.getItemStack(Material.NOTE_BLOCK, 1, "", "&6new &7PlaySoundAction(Sound.valueOf(&2\"LEVEL_UP\"&7)&6, &91&6, &91&6&7)"), new PlaySoundAction(Sound.valueOf("LEVEL_UP"), 1, 1))
                        .setGuiItem(1, ItemStackUtil.getItemStack(Material.PAPER, 1, "", "&6new &7SendMessageAction(&2\"OMG!\"&6, &7InventoryAction.&dPICKUP_HALF&7)"), new SendMessageAction("OMG!", InventoryAction.PICKUP_HALF))
                        .setGuiItem(2, ItemStackUtil.getItemStack(Material.BEACON, 1, "", "&6new &7ConsoleCommandAction(&2\"say %player% lol\"&7)"), new ConsoleCommandAction("say %player% lol"))
                        .setGuiItem(3, ItemStackUtil.getItemStack(Material.BEACON, 1, "", "&6new &7PlayerCommandAction(&2\"say lol\"&7)"), new PlayerCommandAction("say lol"))
                        .setGuiItem(6, ItemStackUtil.getItemStack(Material.EMERALD, 1, "", "&6new &7ExchangeItemStackAction(;;    &6new &7ItemStack(Material.&5EMERALD&7)&6,;;    &6new &7ItemStack(Material.&5DIAMOND&7);;&7)"),
                                new ExchangeItemStackAction(
                                        new ItemStack(Material.EMERALD),
                                        new ItemStack(Material.DIAMOND)
                                ))
                        .setGuiItem(7,
                                ItemStackUtil.getItemFromConfig(config, "armor"),
                                new ExchangeItemStackAction(
                                    new ItemStack(Material.STONE),
                                    ItemStackUtil.getItemFromConfig(config, "armor")
                        ));
                builder = builder.setGuiItem(8, ItemStackUtil.getItemStack(Material.BARRIER, 1, "", "&6new &7CloseInventoryAction()"), new CloseInventoryAction());

                builder = builder.setGuiItem(0, new ItemStack(Material.STONE), event -> {

                });

                builder.open(player);

                //player.getInventory().addItem(ItemStackUtil.getItemFromConfig(config, "test"));

            }

        }

        return true;
    }
}
