package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CollectListener implements Listener {

    public void onCollect(PlayerPickupItemEvent e){
        Player p = e.getPlayer();

        if (!LobbySystem.getPlugin().getBuildersManager().isBuilder(p)){
            e.setCancelled(true);
        }
    }

}
