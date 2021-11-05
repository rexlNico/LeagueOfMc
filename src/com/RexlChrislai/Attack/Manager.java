package com.RexlChrislai.Attack;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.RexlChrislai.AttackUses.Attack_Garen;
import com.RexlChrislai.AttackUses.Attack_Talon;
import com.RexlChrislai.AttackUses.Attack_YI;

public class Manager implements Listener{

	public static ArrayList<Attack> listeners = new ArrayList<>();
	
	public void inlist(){
		listeners.add(new Attack_YI());
		listeners.add(new Attack_Garen());
		listeners.add(new Attack_Talon());
	}
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			for(Attack at : listeners) {
				at.Listener(e);
			}
		}
	}

	public static ArrayList<Attack> getListeners() {
		return listeners;
	}

	public static void addListeners(Attack attack) {
		if(!listeners.contains(attack)) {
			listeners.add(attack);
		}
	}
	
	
	
}
