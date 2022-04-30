package net.vybemc.lobbysystem.util;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {


    private void fillInventory(Inventory inventory, ItemStack item) {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, item);
        }
    }

    public void setLobbyInventory(Player p) {

        Inventory inv = p.getInventory();

        ItemStack navigatorItem = new ItemBuilder(Material.COMPASS).setDisplayName("§c§lNavigator §8» §7§o(Right Click)");
        ItemStack gadgetItem = new ItemBuilder(Material.BLAZE_ROD).setDisplayName("§6§lGadget §8» §7§o(Right Click)");

        inv.setItem(3, navigatorItem);
        inv.setItem(5, gadgetItem);

    }

    public void openNavigatorMainInventory(Player p) {
        
        Inventory inv = Bukkit.createInventory(null, 3*9, "§7Navigator §8» §7Main menu");

        ItemStack buildFFAItem = new ItemBuilder(Material.SANDSTONE).setDisplayName("§e§lBuild FFA");
        ItemStack bedwarsItem = new ItemBuilder(Material.BED).setDisplayName("§6§lBedwars");
        ItemStack skywarsItem = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayName("§b§lSkywars");

        fillInventory(inv, new ItemBuilder(Material.STAINED_GLASS_PANE, DyeColor.WHITE).setDisplayName(" "));

        inv.setItem(11, buildFFAItem);
        inv.setItem(13, bedwarsItem);
        inv.setItem(15, skywarsItem);

        p.openInventory(inv);

    }

}
