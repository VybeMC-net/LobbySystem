package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage(null);

        LobbySystem.getPlugin().getInventoryManager().setLobbyInventory(e.getPlayer());
    }

}
