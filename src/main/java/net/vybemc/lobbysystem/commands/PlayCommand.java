package net.vybemc.lobbysystem.commands;

import net.vybemc.lobbysystem.LobbySystem;
import net.vybemc.lobbysystem.util.CloudManager;
import net.vybemc.lobbysystem.util.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class PlayCommand implements CommandExecutor {

    private final CloudManager cloudManager = LobbySystem.getPlugin().getCloudManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;
            if (args.length >= 1){

                String mode = args[0].toLowerCase();
                switch (mode){
                    case "bedwars":
                        cloudManager.sendPlayer(p, "bedwars");
                    case "skywars":
                        cloudManager.sendPlayer(p, "skywars");
                    case "buildffa":
                        cloudManager.sendPlayer(p, "buildffa");
                    default:
                        p.sendMessage(StringUtils.getLobbyPrefix() + "This gamemode wasn't found.");

                }

            }else {
                p.sendMessage(StringUtils.getLobbyPrefix() + "Wrong use. Try /play <mode>.");
            }

        }

        return false;
    }
}
