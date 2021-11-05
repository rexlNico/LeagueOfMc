package com.RexlChrislai.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.RexlChrislai.Api.Factory;
import com.RexlChrislai.Api.ItemBuilder;
import com.RexlChrislai.Api.Tower;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Gamestate.Lobby_STATE;
import com.RexlChrislai.Main.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(GamestateHandler.getGamestate() instanceof Lobby_STATE){
			
			Tower.spawnringR(p.getLocation(), 6);
			p.teleport(Factory.getConfigLocation("Spawn.Lobby", Var.cfg));
			Var.playing.add(p);
			p.getInventory().clear();
			p.setHealth(20);
			p.setFoodLevel(20);
			p.getInventory().setItem(8, new ItemBuilder(Material.SLIME_BALL, 1).setName("§cVerlassen").build());
			p.getInventory().setItem(0, new ItemBuilder(Material.PAPER, 1).setName("§aTeam wählen").build());
			p.getInventory().setItem(4, new ItemBuilder(Material.BANNER, 1).setName("§aChampion wählen").build());
			
			Lobby_STATE ls = (Lobby_STATE) GamestateHandler.getGamestate();
			
			if(Var.playing.size() >= Var.MIN_PLAYERS){
				if(ls.getCountdown().isRunning == false){
					ls.getCountdown().stopIdle();
					ls.getCountdown().start();
				}
			}
			if(Var.playing.size() < Var.MIN_PLAYERS){
				if(ls.getCountdown().isIdelind == false){
					ls.getCountdown().idle();
				}
			}
			
		}else{
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("lobby-01");
				p.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
		}
	}
}
