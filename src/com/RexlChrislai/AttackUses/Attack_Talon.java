package com.RexlChrislai.AttackUses;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.RexlChrislai.Attack.Attack;
import com.RexlChrislai.Attack.AttackManager;
import com.RexlChrislai.Attack.PAttack;

public class Attack_Talon extends Attack{

	@Override
	public void Listener(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getItemInHand();
		
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

	@Override
	public void q(Player p) {
		PAttack pa = AttackManager.PAttacks.get(p);
		if(pa.cooldownQ()) {
			
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
