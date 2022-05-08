package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        e.setJoinMessage(null);

        LobbySystem.getPlugin().getInventoryManager().setLobbyInventory(p);
        LobbySystem.getPlugin().getScoreboardUtils().setScoreboard(p);

        for (Player all : Bukkit.getOnlinePlayers()){
            LobbySystem.getPlugin().getLevelBarUtils().setLevelBarToCurrentPlayers(all);
        }
    }

}
