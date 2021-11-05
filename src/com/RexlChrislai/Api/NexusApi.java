package com.RexlChrislai.Api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NexusApi {

	private Location red;
	private Location blue;
	private ArmorStand rot;
	private ArmorStand blau;
	public static boolean nexusR, nexusB;
	
	public NexusApi(Location nexusred, Location nexusblue) {
		this.red = nexusred;
		this.blue = nexusblue;
		nexusR = true;
		nexusB = true;
	}
	
	public void setNexus(){
		
		int nexusHP = 5500;
		
		red.getBlock().setType(Material.DIAMOND_BLOCK);
		blue.getBlock().setType(Material.DIAMOND_BLOCK);
		
		
		rot = (ArmorStand) Bukkit.getWorld(red.getWorld().getName()).spawnEntity(new Location(red.getWorld(), red.getX(), red.getY()-1, red.getZ()), EntityType.ARMOR_STAND);
		blau = (ArmorStand) Bukkit.getWorld(blue.getWorld().getName()).spawnEntity(new Location(blue.getWorld(), blue.getX(), blue.getY()-1, blue.getZ()), EntityType.ARMOR_STAND);
		rot.setCustomNameVisible(true);
		rot.setVisible(true);
		rot.setCustomName("§f"+nexusHP);
		rot.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1));
		
		blau.setCustomNameVisible(true);
		blau.setVisible(true);
		blau.setCustomName("§f"+nexusHP);
		blau.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1));
		
		this.red = red.getBlock().getLocation();
		this.blue = blue.getBlock().getLocation();
		
	}
	
	public Location getRed() {
		return red;
	}

	public Location getBlue() {
		return blue;
	}
	
	public void damageNexus(int damage, String redOREblue){
		if(redOREblue.equalsIgnoreCase("red")){
			int hp = Integer.valueOf(rot.getCustomName().replaceAll("§f", ""))-damage;
			if(hp < 1){
				rot.remove();
				red.getBlock().setType(Material.AIR);
				nexusR = false;
				return;
			}
			rot.setCustomName("§f"+hp);
		}else if(redOREblue.equalsIgnoreCase("blue")){
			int hp = Integer.valueOf(blau.getCustomName().replaceAll("§f", ""))-damage;
			if(hp < 1){
				blau.remove();
				blue.getBlock().setType(Material.AIR);
				nexusB = false;
				return;
			}
			blau.setCustomName("§f"+hp);
		}
	}
	
	public boolean redNexus(){
		return nexusR;
	}
	public boolean blueNexus(){
		return nexusB;
	}
	
}
