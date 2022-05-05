package net.vybemc.lobbysystem;

import net.vybemc.lobbysystem.commands.BuildCommand;
import net.vybemc.lobbysystem.commands.PlayCommand;
import net.vybemc.lobbysystem.events.*;
import net.vybemc.lobbysystem.gadgets.TeleporterGadget;
import net.vybemc.lobbysystem.inventories.NavigatorInventory;
import net.vybemc.lobbysystem.util.ActionBar;
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
    private ActionBar actionBar;

    @Override
    public void onEnable() {

        registerInstances();
        registerCommands();
        registerListeners();

    }

    @Override
    public void onDisable() {

        actionBar.setRunning(false);

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
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new DamageListener(), this);

        pm.registerEvents(new BuildersManager(), this);
        pm.registerEvents(new NavigatorInventory(), this);
        pm.registerEvents(new TeleporterGadget(), this);
    }

    private void registerInstances() {

        instance = this;
        buildersManager = new BuildersManager();
        inventoryManager = new InventoryManager();
        cloudManager = new CloudManager();
        actionBar = new ActionBar("§e§lNEW §8» §7Lobby System Alpha Release");

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
