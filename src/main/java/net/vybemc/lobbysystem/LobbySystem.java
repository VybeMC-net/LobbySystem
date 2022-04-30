package net.vybemc.lobbysystem;

import net.vybemc.lobbysystem.commands.BuildCommand;
import net.vybemc.lobbysystem.events.BuildBreakListener;
import net.vybemc.lobbysystem.events.JoinListener;
import net.vybemc.lobbysystem.events.QuitListener;
import net.vybemc.lobbysystem.util.BuildersManager;
import net.vybemc.lobbysystem.util.ConfigManager;
import net.vybemc.lobbysystem.util.InventoryManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;
    private ConfigManager configManager;
    private BuildersManager buildersManager;
    private InventoryManager inventoryManager;

    @Override
    public void onEnable() {

        registerInstances();
        registerCommands();

    }

    private void registerCommands() {

        getCommand("build").setExecutor(new BuildCommand());

    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new BuildersManager(), this);
        pm.registerEvents(new BuildBreakListener(), this);
    }

    private void registerInstances() {

        instance = this;
        configManager = new ConfigManager();
        buildersManager = new BuildersManager();
        inventoryManager = new InventoryManager();

    }

    public static LobbySystem getPlugin() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public BuildersManager getBuildersManager() {
        return buildersManager;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}
