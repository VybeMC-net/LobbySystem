package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import net.vybemc.lobbysystem.util.BuildersManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildBreakListener implements Listener {

    private BuildersManager buildersManager = LobbySystem.getPlugin().getBuildersManager();

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (!buildersManager.isBuilder(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (!buildersManager.isBuilder(p)) {
            e.setCancelled(true);
        }
    }

}
