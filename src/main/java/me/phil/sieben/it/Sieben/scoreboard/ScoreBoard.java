package me.phil.sieben.it.Sieben.scoreboard;

import me.phil.sieben.it.Sieben.It;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.*;

import java.util.List;


public class ScoreBoard {


    public static void CreateBoard(Player player) {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("AtmosBoard", "dummy", "§5§lAtmos§d§lBoard");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);


        Team rankteam = scoreboard.registerNewTeam("rank");
        Team cointeam = scoreboard.registerNewTeam("coin");
        Team timeteam = scoreboard.registerNewTeam("time");
        Team worldteam = scoreboard.registerNewTeam("world");

        rankteam.addEntry("§a");
        cointeam.addEntry("§b");
        timeteam.addEntry("§c");
        worldteam.addEntry("§d");

        Score score = obj.getScore("§8----------------§7");

        Score score2 = obj.getScore("§1");
        Score score3 = obj.getScore("§6Your Rank is:");
        Score score4 = obj.getScore("§a");
        Score score5 = obj.getScore("§2");
        Score score6 = obj.getScore("§6You Have:");
        Score score7 = obj.getScore("§b");
        Score score8 = obj.getScore("§3");
        Score score9 = obj.getScore("§6You have played for:");
        Score score10 = obj.getScore("§c");
        Score score11 = obj.getScore("§4");
        Score score12 = obj.getScore("§6You are in World:");
        Score score13 = obj.getScore("§d");
        Score score14 = obj.getScore("§5");

        Score score15 = obj.getScore("§8----------------§6");


        score.setScore(15);
        score2.setScore(14);
        score3.setScore(13);
        score4.setScore(12);
        score5.setScore(11);
        score6.setScore(10);
        score7.setScore(9);
        score8.setScore(8);
        score9.setScore(7);
        score10.setScore(6);
        score11.setScore(5);
        score12.setScore(4);
        score13.setScore(3);
        score14.setScore(2);
        score15.setScore(1);


        player.setScoreboard(scoreboard);

    }


    public static void updateScoreboard(Player player) {
        Scoreboard board = player.getScoreboard();

        board.getTeam("rank").setPrefix(getRank(player));
        board.getTeam("coin").setPrefix(getCoins(player));
        board.getTeam("time").setPrefix(getPlayTime(player));
        board.getTeam("world").setPrefix(getWorld(player));

    }


    public static String getRank(Player player) {
        List<String> permissions = It.getInstance().getConfig().getStringList("Scoreboard.Permission-Name");

        for (String perm : permissions) {
            if (player.hasPermission(perm)) {
                return It.getInstance().getConfig().getString("Scoreboard.Permission-Prefix." + perm).replaceAll("&", "§");
            }
        }

        return "§aPlayer";
    }

    public static String getCoins(Player player) {
        double coins = It.getEconomy().getBalance(player.getName());
        return "§9" + coins + " §6coins";
    }

    public static String getPlayTime(Player player) {
        long minutesPlayed = player.getPlayerTime() / 20 / 60;
        long hoursPlayed = player.getPlayerTime() / 20 / 60 / 60;
        long daysPlayed = player.getPlayerTime() / 20 / 60 / 60 / 24;

        if (minutesPlayed < 60) return "§9" + minutesPlayed + " §6minutes";
        else if (minutesPlayed > 59 && minutesPlayed < 1440) return "§9" +  hoursPlayed + " §6hours";
        else if (hoursPlayed > 24) return "§9" +  daysPlayed + " §6days";
        else return "§6idk too long i think";

    }

    public static String getWorld(Player player) {
        List<String> worldNames = It.getInstance().getConfig().getStringList("Scoreboard.World-Name");

        for (String world : worldNames) {
            if (player.getWorld().getName().equalsIgnoreCase(world)) {
                return It.getInstance().getConfig().getString("Scoreboard.World-Prefix." + world).replaceAll("&", "§");
            }
        }
        return "Spawn";
    }

}
