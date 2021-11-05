package com.RexlChrislai.Attack;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.ItemBuilder;

public class AttackManager {

	public static HashMap<Player, PAttack> PAttacks;
	public static HashMap<Player, Integer> lives;
	
	public AttackManager() {
		
		PAttacks = new HashMap<>();
		lives = new HashMap<>();
		
	}
	
	public static void giveItems(Player p){
		p.getInventory().setItem(0, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 1).setName("§1Q").build());
		p.getInventory().setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 2).setName("§1W").build());
		p.getInventory().setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 3).setName("§1E").build());
		p.getInventory().setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 4).setName("§1R").build());
		p.getInventory().setItem(8, new ItemBuilder(Material.GLOWSTONE_DUST, 1).setName("§1Rückruf").build());
	}
	
}
