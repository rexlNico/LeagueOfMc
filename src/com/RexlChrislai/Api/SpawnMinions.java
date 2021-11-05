package com.RexlChrislai.Api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import com.RexlChrislai.Main.Main;

public class SpawnMinions {
	
	private static Location red1;
	private static Location red2;
	private static Location red3;
	private static Location blue1;
	private static Location blue2;
	private static Location blue3;
	public static int taskID, taskID2, count;
	
	public SpawnMinions(Location red1, Location red2, Location red3, Location blue1, Location blue2, Location blue3) {
		this.red1 = red1;
		this.red2 = red2;
		this.red3 = red3;
		this.blue1 = blue1;
		this.blue2 = blue2;
		this.blue3 = blue3;
	}

	public void startSpawn(){
		count = 0;
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				taskID2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
					@Override
					public void run() {
						Spawn(red1, "red");
						Spawn(red2, "red");
						Spawn(red3, "red");
						Spawn(blue1, "blue");
						Spawn(blue2, "blue");
						Spawn(blue3, "blue");
						count++;
						if(count == 4){
							count = 0;
							Bukkit.getScheduler().cancelTask(taskID2);
						}
					}
				}, 0, 20*1);
			}
		}, 0, 20*60);
	}
	
	@SuppressWarnings("deprecation")
	public void Spawn(Location loc, String team){
		
					if(team == "red"){
					ItemStack item = new ItemStack(Material.WOOL, 1, (short)14);
					
					Zombie zombie = (Zombie) loc.getWorld().spawnCreature(loc, EntityType.ZOMBIE);
					zombie.setCustomName("§4Minion");
					zombie.setCustomNameVisible(true);
					zombie.setBaby(true);
					zombie.getEquipment().setHelmet(item);
					zombie.setHealth(20);
					zombie.setMaxHealth(60);
					
					}else if(team == "blue"){
						
						ItemStack item = new ItemStack(Material.WOOL, 1, (short)11);
						
						Zombie zombie = (Zombie) loc.getWorld().spawnCreature(loc, EntityType.ZOMBIE);
						zombie.setCustomName("§1Minion");
						zombie.setCustomNameVisible(true);
						zombie.setBaby(true);
						zombie.getEquipment().setHelmet(item);
						zombie.setHealth(20);
						zombie.setMaxHealth(60);
						
					}
			
		
	}
	
}
