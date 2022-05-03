package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getAction() != null && e.getMaterial() != null){
            if (e.getAction() == Action.RIGHT_CLICK_AIR
                    || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (!LobbySystem.getPlugin().getBuildersManager().isBuilder(p)){
                    if (e.getMaterial() == Material.COMPASS) {
                        LobbySystem.getPlugin().getInventoryManager().openNavigatorMainInventory(p);
                    }
                }

            }
        }
    }

}
