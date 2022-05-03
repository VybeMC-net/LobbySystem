package net.vybemc.lobbysystem.inventories;

import net.vybemc.lobbysystem.LobbySystem;
import net.vybemc.lobbysystem.util.CloudManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class NavigatorInventory implements Listener {

    private final CloudManager cloudManager = LobbySystem.getPlugin().getCloudManager();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() != null
        && e.getInventory().getName() != null){

            ItemStack item = e.getCurrentItem();
            String inventoryName = e.getInventory().getName();

            if (inventoryName.endsWith("Main menu")){
                if(item.getType() == Material.BED){
                    cloudManager.sendPlayer(p, "bedwars");
                }else if(item.getType() == Material.SANDSTONE) {
                    cloudManager.sendPlayer(p, "buildffa");
                }else if (item.getType() == Material.EYE_OF_ENDER){
                    cloudManager.sendPlayer(p, "skywars");
                }
            }

        }
    }

}
