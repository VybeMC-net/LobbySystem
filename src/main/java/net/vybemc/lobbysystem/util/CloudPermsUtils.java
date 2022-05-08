package net.vybemc.lobbysystem.util;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.permission.IPermissionGroup;
import de.dytanic.cloudnet.driver.permission.IPermissionManagement;
import de.dytanic.cloudnet.driver.permission.IPermissionUser;
import org.bukkit.entity.Player;

public class CloudPermsUtils {

    public IPermissionManagement getPermissionManagement(){
        return CloudNetDriver.getInstance().getPermissionManagement();
    }

    public IPermissionUser getPermissionUser(Player p){
        return getPermissionManagement().getUser(p.getUniqueId());
    }

    public IPermissionGroup getPermissionGroup(Player p){
        return getPermissionManagement().getHighestPermissionGroup(getPermissionUser(p));
    }

    public String getColor(Player p){
        return getPermissionGroup(p).getColor();
    }

    public String getTranslatedColor(Player p){
        return getColor(p).replaceAll("&", "§");
    }

    public String getPrefix(Player p){
        return getPermissionGroup(p).getPrefix();
    }

    public String getDisplay(Player p){
        return getPermissionGroup(p).getDisplay();
    }

    public String getSuffix(Player p){
        return getPermissionGroup(p).getSuffix();
    }

    public String getRank(Player p){
        return getPermissionGroup(p).getName();
    }

}
