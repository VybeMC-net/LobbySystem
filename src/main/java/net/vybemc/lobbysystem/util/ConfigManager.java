package net.vybemc.lobbysystem.util;

import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public ConfigManager() {
        createMySQLConfig();
    }

    private void createMySQLConfig() {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(LobbySystem.getPlugin().getResource("mysql.yml"));

        try {
            config.save(LobbySystem.getPlugin().getDataFolder() + "/mysql.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlConfiguration getMySQLConfig() {
        return YamlConfiguration.loadConfiguration(new File(LobbySystem.getPlugin().getDataFolder() + "/mysql.yml"));
    }

}
