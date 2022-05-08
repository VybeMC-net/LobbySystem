package net.vybemc.lobbysystem.events;

import de.dytanic.cloudnet.driver.event.EventListener;
import de.dytanic.cloudnet.ext.bridge.event.BridgeServerPlayerLoginSuccessEvent;
import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NetworkJoinListener {

    @EventListener
    public void handle(BridgeServerPlayerLoginSuccessEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()){
                    LobbySystem.getPlugin().getLevelBarUtils().setLevelBarToCurrentPlayers(all);
                }
            }
        }.runTaskLater(LobbySystem.getPlugin(), 20);
    }

}
