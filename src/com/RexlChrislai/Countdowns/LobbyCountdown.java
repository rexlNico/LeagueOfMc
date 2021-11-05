package com.RexlChrislai.Countdowns;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Gamestate.Gamestate;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Main.Main;


public class LobbyCountdown extends Countdown{

	private int sec = 16;
	private int taskID, idlID;
	public static boolean isRunning = false, isIdelind = false;
	
	@Override
	public void start() {	
		isRunning = true;
		
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				sec--;
				for(Player a : Var.playing){
					a.setLevel(sec);
				}
				
				switch (sec) {
				case 15: case 5: case 4: case 3: case 2:
					Bukkit.broadcastMessage(Var.pr+"Das Spiel startet in §b"+sec+" §7sekunden.");
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.LAVA_POP, 1, 1);
					}
					break;

				case 1:
					Bukkit.broadcastMessage(Var.pr+"Das Spiel startet in §beiner §7sekunde.");
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.LAVA_POP, 1, 1);
					}
					break;
					
				case 0:
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
					}
					GamestateHandler.setGameState(Gamestate.INGAME_STATE);
					stop();
					break;
				default:
					break;
				}
			}
		}, 0, 20*1);
	}
	
	public void idle(){
		isIdelind = true;
		idlID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
			
				int missing = Var.MIN_PLAYERS - Var.playing.size();
				Bukkit.broadcastMessage(Var.pr+"§cZum Start fehlen noch §b"+missing+"§c Spieler.");
				
			}
		}, 0, 20*60*2);
	}

	public void stopIdle(){
		if(isIdelind){
			isIdelind = false;
			Bukkit.getScheduler().cancelTask(idlID);
		}
	}
	public void stopCountDown(){
		if(isRunning){
			isRunning = false;
			Bukkit.getScheduler().cancelTask(taskID);
			sec = 60;
		}
	}
	
	public void setSec(int Sec){
		this.sec = Sec;
	}
	
	public int getSec(){
		return sec;
	}
	
	@Override
	public void stop() {
		isIdelind = false;
		isRunning = false;
		Bukkit.getScheduler().cancelTask(taskID);
		Bukkit.getScheduler().cancelTask(idlID);
		sec = 30;
	}

}
