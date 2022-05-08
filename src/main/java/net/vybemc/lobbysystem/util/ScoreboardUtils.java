package net.vybemc.lobbysystem.util;

import de.dytanic.cloudnet.driver.event.EventListener;
import de.dytanic.cloudnet.driver.event.events.permission.PermissionUpdateUserEvent;
import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtils {

    private final CloudPermsUtils cloudPermsUtils = LobbySystem.getPlugin().getCloudPermsUtils();

    public void setScoreboard(Player p){

        if (p.getScoreboard() == Bukkit.getScoreboardManager().getMainScoreboard()){
            p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }

        Scoreboard sb = p.getScoreboard();

        if (sb.getObjective("display") != null){
            sb.getObjective("display").unregister();
        }

        Objective obj = sb.registerNewObjective("display", "dummy");

        obj.setDisplayName("§6§lVybeMC");

        obj.getScore(" ");
        obj.getScore("§0");
        obj.getScore("§7Server: §6"
                + LobbySystem.getPlugin().getCloudManager().getServer(p));
        obj.getScore("§8§m----------");
        obj.getScore("§7§oVybeMC.net");


        Team rank = getTeam(sb, "rank");
        rank.addEntry("§0");
        rank.setPrefix("§7Rank: "
                + cloudPermsUtils.getColor(p)
                + cloudPermsUtils.getRank(p));

    }

    public void updateScoreboard(Player p){
        Scoreboard sb = p.getScoreboard();

        Team rank = getTeam(sb, "rank");
        rank.addEntry("§0");
        rank.setPrefix("§7Rank: "
                + cloudPermsUtils.getColor(p)
                + cloudPermsUtils.getRank(p));
    }

    private Team getTeam(Scoreboard sb, String s){
        if (sb.getTeam(s) == null){
            return sb.registerNewTeam(s);
        }

        return sb.getTeam(s);
    }

}
