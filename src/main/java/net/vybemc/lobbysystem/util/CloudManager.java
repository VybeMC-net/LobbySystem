package net.vybemc.lobbysystem.util;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.provider.service.GeneralCloudServiceProvider;
import de.dytanic.cloudnet.ext.bridge.node.CloudNetBridgeModule;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import de.dytanic.cloudnet.ext.bridge.server.BridgeServerHelper;
import org.bukkit.entity.Player;

public class CloudManager {

    public void sendPlayer(Player p, String serviceName){
        IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
        ICloudPlayer cloudPlayer = playerManager.getOnlinePlayer(p.getUniqueId());
        if (cloudPlayer != null){
            playerManager.getPlayerExecutor(cloudPlayer).connect(serviceName);
        }
    }

    public int getMaxPlayersOnNetwork(){
        return BridgeServerHelper.getMaxPlayers();
    }

    public int getCurrentPlayersOnNetwork(){
        IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
        return playerManager.getOnlineCount();
    }

    public String getServer(Player p){
        IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
        ICloudPlayer cloudPlayer = playerManager.getOnlinePlayer(p.getUniqueId());

        assert cloudPlayer != null;
        return cloudPlayer.getConnectedService().getServerName();
    }

}
