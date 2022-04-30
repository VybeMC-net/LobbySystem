package net.vybemc.lobbysystem.inventories;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class NavigatorInventory implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getCurrentItem() != null
        && e.getInventory().getName() != null){

            ItemStack item = e.getCurrentItem();
            String inventoryName = e.getInventory().getName();

        }
    }

}
