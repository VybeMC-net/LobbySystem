package net.vybemc.lobbysystem.util;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.entity.Player;

public class LevelBarUtils {

    private final CloudManager cloudManager = LobbySystem.getPlugin().getCloudManager();

    public void setLevel(Player p, int level){
        p.setLevel(level);
    }

    public void setLevelProgress(Player p, float progress){
        p.setExp(progress);
    }

    public void setLevelBarToCurrentPlayers(Player p){
        int players = cloudManager.getCurrentPlayersOnNetwork();
        int maxPlayers = cloudManager.getMaxPlayersOnNetwork();

        setLevel(p, players);
        setLevelProgress(p, (players/maxPlayers));
    }

}
