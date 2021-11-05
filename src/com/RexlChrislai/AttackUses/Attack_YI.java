package com.RexlChrislai.AttackUses;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Attachable;

import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Attack.Attack;
import com.RexlChrislai.Attack.AttackManager;
import com.RexlChrislai.Attack.PAttack;
import com.RexlChrislai.Champions.ChampionManager;

public class Attack_YI extends Attack{

	@Override
	public void Listener(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getItemInHand();
		if(ChampionManager.championwahl.get(p).getAttack() instanceof Attack_YI) {
			if(AttackManager.PAttacks.containsKey(p)) {
				if(item.getItemMeta().getDisplayName().equals("§1Q")) {
					q(p);
				}else if(item.getItemMeta().getDisplayName().equals("§1W")) {
					w(p);
				}else if(item.getItemMeta().getDisplayName().equals("§1E")) {
					e(p);
				}else if(item.getItemMeta().getDisplayName().equals("§1R")) {
					r(p);
				}
			}
		}
		
	}

	@Override
	public void q(Player p) {
		PAttack pa = AttackManager.PAttacks.get(p);
		if(pa.cooldownQ()) {
			int i = 0;
			boolean b = false;
			for(Entity e : p.getNearbyEntities(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())) {
				if(e instanceof Zombie) {
					Zombie z = (Zombie) e;
					if(b && i == 0) {
						for(Player a : Var.playing) {
							a.hidePlayer(p);
						}
						b = false;
					}
					if(i < 5) {
						p.teleport(e);
						z.setHealth(z.getHealth()-2.5);
						i++;
					}else if(!b){
						b = true;
						for(Player a : Var.playing) {
							a.showPlayer(p);
						}
					
					}
				}
			}
			
		}
	}

	@Override
	public void w(Player p) {
		PAttack pa = AttackManager.PAttacks.get(p);
		if(pa.cooldownW()) {
			
		}
	}

	@Override
	public void e(Player p) {
		PAttack pa = AttackManager.PAttacks.get(p);
		if(pa.cooldownE()) {
			
		}
	}

	@Override
	public void r(Player p) {
		PAttack pa = AttackManager.PAttacks.get(p);
		if(pa.cooldownR()) {
			
		}
	}


}
