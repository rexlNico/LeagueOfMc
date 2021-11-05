package com.RexlChrislai.Attack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damage implements Listener{

	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getEntity();
		Player da = (Player) e.getDamager();
		
		
	}
	
}
