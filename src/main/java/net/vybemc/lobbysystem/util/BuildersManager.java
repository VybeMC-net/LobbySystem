package net.vybemc.lobbysystem.util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class BuildersManager implements Listener {

    private ArrayList<Player> builders;

    public BuildersManager() {
        builders = new ArrayList<>();
    }

    public void addBuilder(Player player) {
        builders.add(player);
    }

    public void removeBuilder(Player player) {
        builders.remove(player);
    }

    public boolean isBuilder(Player player) {
        return builders.contains(player);
    }

    public ArrayList<Player> getBuilders() {
        return builders;
    }

    public void setBuilders(ArrayList<Player> builders) {
        this.builders = builders;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        if (isBuilder(p)) {
            removeBuilder(p);
        }
    }
}

