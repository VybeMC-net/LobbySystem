package net.vybemc.lobbysystem;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import net.vybemc.lobbysystem.commands.BuildCommand;
import net.vybemc.lobbysystem.commands.PlayCommand;
import net.vybemc.lobbysystem.events.*;
import net.vybemc.lobbysystem.gadgets.TeleporterGadget;
import net.vybemc.lobbysystem.inventories.NavigatorInventory;
import net.vybemc.lobbysystem.util.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;
    private BuildersManager buildersManager;
    private InventoryManager inventoryManager;
    private CloudManager cloudManager;
    private ActionBar actionBar;
    private CloudPermsUtils cloudPermsUtils;
    private ScoreboardUtils scoreboardUtils;
    private LevelBarUtils levelBarUtils;

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

        CloudNetDriver.getInstance().getEventManager().registerListener(new GroupUpdateListener());
    }

    private void registerInstances() {

        instance = this;
        buildersManager = new BuildersManager();
        inventoryManager = new InventoryManager();
        cloudManager = new CloudManager();
        cloudPermsUtils = new CloudPermsUtils();
        scoreboardUtils = new ScoreboardUtils();
        levelBarUtils = new LevelBarUtils();

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

    public CloudPermsUtils getCloudPermsUtils() {
        return cloudPermsUtils;
    }

    public ScoreboardUtils getScoreboardUtils() {
        return scoreboardUtils;
    }

    public LevelBarUtils getLevelBarUtils() {
        return levelBarUtils;
    }
}
