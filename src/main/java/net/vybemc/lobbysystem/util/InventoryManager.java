package net.vybemc.lobbysystem.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {


    public void setLobbyInventory(Player p) {

        Inventory inv = p.getInventory();

        ItemStack navigatorItem = new ItemBuilder(Material.COMPASS).setDisplayName("§c§lNavigator §7§o(Right Click)");
        ItemStack gadgetItem = new ItemBuilder(Material.BLAZE_ROD).setDisplayName("§6§lGadget §7§o(Right Click)");

        inv.setItem(3, navigatorItem);
        inv.setItem(5, gadgetItem);

    }

}
