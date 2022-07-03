package me.phil.sieben.it.Sieben.listeners;

import me.phil.sieben.it.Sieben.It;
import me.phil.sieben.it.Sieben.scoreboard.ScoreBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;



public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ScoreBoard.CreateBoard(event.getPlayer());

        new BukkitRunnable() {
            @Override
            public void run() {
                ScoreBoard.updateScoreboard(event.getPlayer());
            }
        }.runTaskTimer(It.getInstance(), 20L * It.getInstance().getConfig().getInt("Scoreboard.Refresh-Time"),1);


    }
}
