package net.vybemc.lobbysystem.gadgets;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class TeleporterGadget implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getAction() != null
        && e.getMaterial() != null){
            if (e.getAction() == Action.RIGHT_CLICK_AIR
            || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(e.getMaterial() == Material.BLAZE_ROD){
                    if (!LobbySystem.getPlugin().getBuildersManager().isBuilder(p)){
                        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                            if (e.getClickedBlock() != null){
                                Location loc = e.getClickedBlock().getLocation();
                                loc.setY(loc.getY() + 1);
                                p.teleport(loc);
                            }
                        }else {
                            Location loc = p.getLocation();
                            Vector dir = loc.getDirection();
                            dir.normalize();
                            dir.multiply(7);
                            loc.add(dir);
                            p.teleport(loc);
                        }
                    }
                }
            }
        }
    }
}
