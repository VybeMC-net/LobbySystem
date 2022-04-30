package net.vybemc.lobbysystem.util;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.node.CloudNetBridgeModule;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import org.bukkit.entity.Player;

public class CloudManager {

    public void sendPlayer(Player p, String serviceName){
        IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
        ICloudPlayer cloudPlayer = playerManager.getOnlinePlayer(p.getUniqueId());
        if (cloudPlayer != null){
            playerManager.getPlayerExecutor(cloudPlayer).connect(serviceName);
        }
    }

}
