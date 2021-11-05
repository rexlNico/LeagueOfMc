package com.RexlChrislai.Listeners;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import com.RexlChrislai.Api.MySQL;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Gamestate.Ingame_STATE;
import com.RexlChrislai.Gamestate.Lobby_STATE;
import com.RexlChrislai.Main.Main;

public class Quit {
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void on(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		if(GamestateHandler.getGamestate() instanceof Lobby_STATE){
			Lobby_STATE ls = (Lobby_STATE) GamestateHandler.getGamestate();
			if(Var.playing.contains(p)) Var.playing.remove(p);
			
			if(Var.playing.size() < Var.MIN_PLAYERS){
				if(ls.getCountdown().isRunning){
					ls.getCountdown().stopCountDown();
					ls.getCountdown().idle();
				}
			}
		}else if(GamestateHandler.getGamestate() instanceof Ingame_STATE){
			Main.mysql.execute("UPDATE Lom SET leaverbuster = 'true' where UUID = '"+p.getUniqueId()+"'");
			Main.mysql.execute("UPDATE Lom SET leaverbusterTIME = '15' where UUID = '"+p.getUniqueId()+"'");
			if(Var.red.contains(p)) Var.red.remove(p);
			if(Var.blue.contains(p)) Var.blue.remove(p);
			Var.playing.remove(p);
			p.sendMessage(Var.pr+"§4Da du das Spiel verlassen hast hast du nun einen 15 minütigen ausschluss aus dem Spielmodus!");
		}
	}
	
}
