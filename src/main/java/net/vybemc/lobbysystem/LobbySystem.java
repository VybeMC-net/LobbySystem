package net.vybemc.lobbysystem;

import net.vybemc.lobbysystem.commands.BuildCommand;
import net.vybemc.lobbysystem.commands.PlayCommand;
import net.vybemc.lobbysystem.events.BuildBreakListener;
import net.vybemc.lobbysystem.events.InventoryClickListener;
import net.vybemc.lobbysystem.events.JoinListener;
import net.vybemc.lobbysystem.events.QuitListener;
import net.vybemc.lobbysystem.inventories.NavigatorInventory;
import net.vybemc.lobbysystem.util.BuildersManager;
import net.vybemc.lobbysystem.util.CloudManager;
import net.vybemc.lobbysystem.util.InventoryManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;
    private BuildersManager buildersManager;
    private InventoryManager inventoryManager;
    private CloudManager cloudManager;

    @Override
    public void onEnable() {

        registerInstances();
        registerCommands();

    }

    private void registerCommands() {

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("play").setExecutor(new PlayCommand());

    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new BuildBreakListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);

        pm.registerEvents(new BuildersManager(), this);
        pm.registerEvents(new NavigatorInventory(), this);
    }

    private void registerInstances() {

        instance = this;
        buildersManager = new BuildersManager();
        inventoryManager = new InventoryManager();
        cloudManager = new CloudManager();

    }

    public static LobbySystem getPlugin() {
        return instance;
    }

    public BuildersManager getBuildersManager() {
        return buildersManager;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public CloudManager getCloudManager() {
        return cloudManager;
    }
}
