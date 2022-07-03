package me.phil.sieben.it.Sieben.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class ScoreBoard {

    public static void CreateBoard(Player player) {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("AtmosBoard", "dummy", "§5§lAtmos§d§lBoard");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = obj.getScore("§8----------------§7");

        Score score2 = obj.getScore("§1");
        Score score3 = obj.getScore("§6Your Rank is:");
        Score score4 = obj.getScore(getRank(player));
        Score score5 = obj.getScore("§2");
        Score score6 = obj.getScore("§6You Have:");
        Score score7 = obj.getScore(getCoins(player));
        Score score8 = obj.getScore("§3");
        Score score9 = obj.getScore("§6You have played for:");
        Score score10 = obj.getScore(getPlayTime(player));
        Score score11 = obj.getScore("§4");
        Score score12 = obj.getScore("§6You are in World:");
        Score score13 = obj.getScore(getWorld(player));
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

    public static String getRank(Player player) {

        if (player.hasPermission("owner")) return "§9Owner";
        if (player.hasPermission("coowner")) return "§9CoOwner";
        if (player.hasPermission("dev")) return "§9Dev";

        return "user";
    }

    public static String getCoins(Player player) {
        return "§9300 §6coins";
    }

    public static String getPlayTime(Player player) {
        return  "§9" + (player.getPlayerTime() /20 /60 / 60 + " §6hours");
    }

    public static String getWorld(Player player) {
        return "§9" + player.getWorld().getName();
    }

}
