package net.vybemc.lobbysystem.util;

import de.dytanic.cloudnet.driver.event.EventListener;
import de.dytanic.cloudnet.driver.event.events.permission.PermissionUpdateUserEvent;
import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtils {

    private final CloudPermsUtils cloudPermsUtils = LobbySystem.getPlugin().getCloudPermsUtils();

    public void setScoreboard(Player p){

        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("display", "dummy");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6§lVybe§f§lMC");

        obj.getScore("§8§m------------------ ").setScore(6);
        obj.getScore("§6§lRank:").setScore(5);
        obj.getScore("§0").setScore(4);
        obj.getScore("§6§lServer:").setScore(3);
        obj.getScore("§8» §f" + LobbySystem.getPlugin().getCloudManager().getServer(p)).setScore(2);
        obj.getScore("§8§m------------------").setScore(1);
        obj.getScore("§7§oVybeMC.net").setScore(0);


        Team rank = getTeam(sb, "rank");
        rank.addEntry("§0");
        rank.setPrefix("§8» "
                + cloudPermsUtils.getTranslatedColor(p)
                + cloudPermsUtils.getRank(p));

        p.setScoreboard(sb);

    }

    public void updateScoreboard(Player p){
        Scoreboard sb = p.getScoreboard();

        Team rank = getTeam(sb, "rank");
        rank.addEntry("§0");
        rank.setPrefix("§8» "
                + cloudPermsUtils.getTranslatedColor(p)
                + cloudPermsUtils.getRank(p));
    }

    private Team getTeam(Scoreboard sb, String s){
        if (sb.getTeam(s) == null){
            return sb.registerNewTeam(s);
        }

        return sb.getTeam(s);
    }

}
