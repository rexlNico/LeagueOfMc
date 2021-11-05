package com.RexlChrislai.Gamestate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Main.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class End_STATE extends Gamestate{

	int sec = 15;
	
	@Override
	public void init() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				
				switch (sec) {
				case 15: case 10: case 5: case 4: case 3: case 2:
					Bukkit.broadcastMessage(Var.pr+"§7Der Server startet in §c"+sec+" §7Sekunden neu!");
					break;
				
				 case 1:
					 Bukkit.broadcastMessage(Var.pr+"§7Der Server startet in §ceiner §7Sekunde neu!");
					 //alle auf lobby schicken
						for(Player a : Bukkit.getOnlinePlayers()){
							ByteArrayDataOutput out = ByteStreams.newDataOutput();
							out.writeUTF("Connect");
							out.writeUTF("lobby-01");
							a.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
						}
						
					 Bukkit.getScheduler().cancelAllTasks();
					 Bukkit.shutdown();
					 break;
				}
				sec--;
				
			}
		}, 0, 20*1);
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
