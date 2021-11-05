package com.RexlChrislai.Champions;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.RexlChrislai.Api.ItemBuilder;
import com.RexlChrislai.AttackUses.Attack_Garen;
import com.RexlChrislai.AttackUses.Attack_Talon;
import com.RexlChrislai.AttackUses.Attack_YI;

public class ChampionManager {
	
	public static HashMap<Player, Champion> championwahl = new HashMap<>();
	public static ArrayList<Champion> champions = new ArrayList<>();
	
	public ChampionManager() {
		champions.add(new Champion(new Attack_Talon(), "Talon", new ItemBuilder(Material.NETHER_STAR, 1).setName("§2Talon").build(), 588, 377, 30, 55 , 0, 100, 7.5, 9, 2, 100));
		champions.add(new Champion(new Attack_YI(), "Master Yi", new ItemBuilder(Material.GOLD_SWORD, 1).setName("§2Master Yi").build(), 599, 250, 70, 50, 0, 100, 18, 35, 18, 85));
		//  champions.add(new Champion("Caitlyn", new ItemBuilder(Material.BOW, 1).setName("§2Caitlyn").build(), , , , , , , , , , ));
		champions.add(new Champion(new Attack_Garen(), "Garen", new ItemBuilder(Material.IRON_CHESTPLATE, 1).setName("§2Garen").build(), 617, 0, 0, 0, 0, 0, 8, 24, 9, 120));
	}
	
	public static void openInv(Player p){
		
		Inventory inv = Bukkit.createInventory(null, 9*5, "§aChampion auswahl");
		
		for(int i = 0; i < champions.size(); i++){
			inv.setItem(i, champions.get(i).getguiItem());
		}
		p.openInventory(inv);
	}
	
	public static Champion getChampion(String Name){
		for(int i = 0; i < champions.size(); i++){
			if(champions.get(i).getName().equals(Name)){
				return champions.get(i);
			}
		}
		return null;
	}
	
	public static void addChampion(Champion champion){
		if(champions.contains(champion)){
			return;
		}
		champions.add(champion);
	}
	
	public static void removeChampion(String Name){
		for(int i = 0; i < champions.size(); i++){
			if(champions.get(i).getName().equals(Name)){
				champions.remove(i);
				return;
			}
		}
	}
	
}
// back = 8 sec