package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import net.vybemc.lobbysystem.util.BuildersManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(!LobbySystem.getPlugin().getBuildersManager().isBuilder(p)){
            e.setCancelled(true);
        }
    }

}
