package com.RexlChrislai.Attack;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Champions.ChampionManager;
import com.RexlChrislai.Main.Main;

public class ManaM {

	public static HashMap<Player, Integer> mana = new HashMap<>();
	
	public ManaM() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), 	new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(Player a : Var.playing) {
					int i = mana.get(a);
					if(!(i >=  AttackManager.PAttacks.get(a).getMana())) {
						mana.remove(a);
						mana.put(a, i+1);
					}
				}
			}
		}, 0, 20*2);
	}
	
}
