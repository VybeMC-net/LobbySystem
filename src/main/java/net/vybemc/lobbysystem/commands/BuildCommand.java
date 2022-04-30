package net.vybemc.lobbysystem.commands;

import net.vybemc.lobbysystem.LobbySystem;
import net.vybemc.lobbysystem.util.BuildersManager;
import net.vybemc.lobbysystem.util.InventoryManager;
import net.vybemc.lobbysystem.util.StringUtils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (args.length > 0) {

        }else {
            if (sender.hasPermission("lobbysystem.build.self")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    BuildersManager buildersManager = LobbySystem.getPlugin().getBuildersManager();
                    InventoryManager inventoryManager = LobbySystem.getPlugin().getInventoryManager();

                    if (buildersManager.isBuilder(p)) {
                        buildersManager.removeBuilder(p);
                        p.setGameMode(GameMode.SURVIVAL);
                        inventoryManager.setLobbyInventory(p);

                        p.sendMessage(StringUtils.getLobbyPrefix() + "You are no longer a builder.");
                    }else {
                        buildersManager.addBuilder(p);
                        p.setGameMode(GameMode.CREATIVE);
                        p.getInventory().clear();

                        p.sendMessage(StringUtils.getLobbyPrefix() + "You are now a builder.");
                    }
                }else {
                    sender.sendMessage(StringUtils.getLobbyPrefix() + "You need to be a player to use this command!");
                }
            }else {
                sender.sendMessage(StringUtils.getNoPermMessage());
            }
        }

        return false;
    }
}
