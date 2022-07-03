package me.phil.sieben.it.Sieben.listeners;

import me.phil.sieben.it.Sieben.scoreboard.ScoreBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ScoreBoard.CreateBoard(event.getPlayer());
    }
}
