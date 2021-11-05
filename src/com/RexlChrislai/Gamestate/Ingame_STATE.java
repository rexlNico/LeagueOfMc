package com.RexlChrislai.Gamestate;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.RexlChrislai.Api.Factory;
import com.RexlChrislai.Api.NexusApi;
import com.RexlChrislai.Api.SpawnMinions;
import com.RexlChrislai.Api.Tower;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Attack.AttackManager;
import com.RexlChrislai.Attack.ManaM;
import com.RexlChrislai.Attack.PAttack;
import com.RexlChrislai.Champions.Champion;
import com.RexlChrislai.Champions.ChampionManager;
import com.RexlChrislai.Main.Main;

public class Ingame_STATE extends Gamestate{

	public static NexusApi nexusAPI = new NexusApi(Factory.getConfigLocation("Nexus.red", Var.cfg), Factory.getConfigLocation("Nexus.blue", Var.cfg));
	public static AttackManager am;
	public static Tower towerAPI;
	public static SpawnMinions minions;
	public int taskID;
	
	
	@SuppressWarnings("static-access")
	@Override
	public void init() {
		am = new AttackManager();
		minions = new SpawnMinions(Factory.getConfigLocation("Minions.red.1", Var.cfg), Factory.getConfigLocation("Minions.red.2", Var.cfg), Factory.getConfigLocation("Minions.red.3", Var.cfg), Factory.getConfigLocation("Minions.blue.1", Var.cfg), Factory.getConfigLocation("Minions.blue.2", Var.cfg), Factory.getConfigLocation("Minions.blue.2", Var.cfg));
//		towerAPI = new Tower(Factory.getConfigLocation("Tower.red.nexus.top", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.nexus.bot", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.top.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.top.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.mid.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.mid.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.bot.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.red.bot.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.top.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.top.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.mid.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.mid.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.bot.1", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.bot.2", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.nexus.top", Var.cfg), 
//				Factory.getConfigLocation("Tower.blue.nexus.top", Var.cfg));
		minions.startSpawn();
		nexusAPI.setNexus();
//		towerAPI.setTower();
//		towerAPI.damagePlayer();
		for(Player a : Var.playing){
			a.closeInventory();
			a.getInventory().clear();
			if(!Var.blue.contains(a) || !Var.red.contains(a)){
				if(Var.blue.size() != 5){
					Var.blue.add(a);
				}
				if(Var.red.size() != 5){
					Var.red.add(a);
				}
				
				AttackManager.giveItems(a);
				
			}
			
			if(!Main.cm.championwahl.containsKey(a)){
				Main.cm.championwahl.put(a, ChampionManager.champions.get(0));
			}
			Champion c = Main.cm.championwahl.get(a);
			am.PAttacks.put(a, new PAttack(a, c.getMaxMana(), c.getqMana(), c.getwMana(), c.geteMana(), c.getrMana(), c.getqCooldown(), c.getwCooldown(), c.geteCooldown(), c.getrCooldown()));
			if(!ManaM.mana.containsKey(a)){
				ManaM.mana.put(a, c.getMaxMana());
				a.setLevel(c.getMaxMana());
			}
		}
		
		new ManaM();
		
		for(Player a : Var.blue){
			a.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 255));
			a.teleport(Factory.getConfigLocation("Spawn.blue", Var.cfg));
		}
		for(Player a : Var.red){
			a.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 255));
			a.teleport(Factory.getConfigLocation("Spawn.red", Var.cfg));
		}
		
		
		
		
		
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				
				if(nexusAPI.blueNexus() == false || Var.blue.isEmpty()){
					GamestateHandler.setGameState(Gamestate.END_STATE);
					for(Player a : Var.red){
						a.sendTitle("§aGewonnen", "");
					}
					for(Player a : Var.blue){
						a.sendTitle("§4Verloren", "");
					}
					return;
				}else if(nexusAPI.redNexus() == false || Var.red.isEmpty()){
					GamestateHandler.setGameState(Gamestate.END_STATE);
					for(Player a : Var.red){
						a.sendTitle("§4Verloren", "");
					}
					for(Player a : Var.blue){
						a.sendTitle("§aGewonnen", "");
					}
					return;
				}
				
			}
		}, 0, 20);
		
		
	}

	@Override
	public void end() {
		
		Bukkit.getScheduler().cancelTask(minions.taskID);
		Bukkit.getScheduler().cancelTask(minions.taskID2);
		Bukkit.getScheduler().cancelTask(taskID);
		
	}

}
