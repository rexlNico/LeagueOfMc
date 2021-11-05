package com.RexlChrislai.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener{
	
	@EventHandler
	public void on(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(!(p.hasPermission("Lom.build") && p.getGameMode().equals(GameMode.CREATIVE))){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(!(p.hasPermission("Lom.build") && p.getGameMode().equals(GameMode.CREATIVE))){
			e.setCancelled(true);
		}
	}
	
}
