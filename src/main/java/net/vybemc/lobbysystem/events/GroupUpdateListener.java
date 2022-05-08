package net.vybemc.lobbysystem.events;

import de.dytanic.cloudnet.driver.event.EventListener;
import de.dytanic.cloudnet.driver.event.events.permission.PermissionUpdateUserEvent;
import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class GroupUpdateListener {

    @EventListener
    public void handle(PermissionUpdateUserEvent e){
        LobbySystem.getPlugin().getScoreboardUtils().updateScoreboard(
                Bukkit.getPlayer(e.getPermissionUser().getUniqueId()));
    }

}
