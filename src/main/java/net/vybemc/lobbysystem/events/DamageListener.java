package net.vybemc.lobbysystem.events;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (!e.getCause().equals(DamageCause.ENTITY_ATTACK)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            if (!LobbySystem.getPlugin().getBuildersManager().isBuilder(damager)){
                e.setCancelled(true);
            }
        }
    }

}
