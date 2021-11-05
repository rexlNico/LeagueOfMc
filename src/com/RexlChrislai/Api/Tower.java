package com.RexlChrislai.Api;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.RexlChrislai.Main.Main;

public class Tower {

	Location redNexusTop;
	Location redNexusBot;
	Location redTop1;
	Location redTop2;
	Location redMid1;
	Location redMid2;
	Location redBot1;
	Location redBot2;
	Location blueNexusTop;
	Location blueNexusBot;
	Location blueTop1;
	Location blueTop2;
	Location blueMid1;
	Location blueMid2;
	Location blueBot1;
	Location blueBot2;
	boolean BredNexusTop = true;
	boolean BredNexusBot = true;
	boolean BredTop1 = true;
	boolean BredTop2 = true;
	boolean BredMid1 = true;
	boolean BredMid2 = true;
	boolean BredBot1 = true;
	boolean BredBot2 = true;
	boolean BblueNexusTop = true;
	boolean BblueNexusBot = true;
	boolean BblueTop1 = true;
	boolean BblueTop2 = true;
	boolean BblueMid1 = true;
	boolean BblueMid2 = true;
	boolean BblueBot1 = true;
	boolean BblueBot2 = true;
	int radius = 6;
	private int taskID;
	
	public Tower(Location redNexusTop, Location redNexusBot, Location redTop1, Location redTop2, Location redMid1, Location redMid2, Location redBot1, Location redBot2, Location blueTop1, Location blueTop2, Location blueMid1, Location blueMid2, Location blueBot1, Location blueBot2, Location blueNexusTop, Location blueNexusBot) {
		this.redNexusTop = redNexusTop;
		this.redNexusBot = redNexusBot;
		this.redTop1 = redTop1;
		this.redTop2 = redTop2;
		this.redMid1 = redMid1;
		this.redMid2 = redMid2;
		this.redBot1 = redBot1;
		this.redBot2 = redBot2;
		this.blueNexusTop = blueNexusTop;
		this.blueNexusBot = blueNexusBot;
		this.blueTop1 = blueTop1;
		this.blueTop2 = blueTop2;
		this.blueMid1 = blueMid1;
		this.blueMid2 = blueMid2;
		this.blueBot1 = blueBot1;
		this.blueBot2 = blueBot2;
	}

	public void setTower(){
		redNexusTop.getBlock().setType(Material.BEACON);
		redNexusBot.getBlock().setType(Material.BEACON);
		redTop1.getBlock().setType(Material.BEACON);
		redTop2.getBlock().setType(Material.BEACON);
		redMid1.getBlock().setType(Material.BEACON);
		redMid2.getBlock().setType(Material.BEACON);
		redBot1.getBlock().setType(Material.BEACON);
		redBot2.getBlock().setType(Material.BEACON);
		blueNexusTop.getBlock().setType(Material.BEACON);
		blueNexusBot.getBlock().setType(Material.BEACON);
		blueTop1.getBlock().setType(Material.BEACON);
		blueTop2.getBlock().setType(Material.BEACON);
		blueMid1.getBlock().setType(Material.BEACON);
		blueMid2.getBlock().setType(Material.BEACON);
		blueBot1.getBlock().setType(Material.BEACON);
		blueBot2.getBlock().setType(Material.BEACON);
	}
	
	public void damageTower(int damage, Location blockLoc){
		
	}
	
	
	public static void spawnringR(Location L, double r) {
		double PI = (double) 3.141592653589793238462643383279502884197169399375105820974944592307816406286208995;
		double x = (double) L.getX();
		double y = (double) L.getZ();
		for (int faktor = 0; faktor <= 150; faktor++) {
		float faktordezimal = (float) faktor / 150;
		float xp = (float) r * (float) Math.cos(faktordezimal * 2 * PI);
		float yp = (float) r * (float) Math.sin(faktordezimal * 2 * PI);
		Location tile = new Location(L.getWorld(), x + xp, L.getY(), y + yp);
		if (tile.getBlock().getType() == Material.AIR) {
		L.getWorld().playEffect(tile, Effect.FLAME, 0);
		}
		}
		} 
	
	public void damagePlayer(){
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				for(Player a : Var.red){
					if(a.getLocation().distance(blueNexusTop) <= radius && BblueNexusTop == true){
						spawnringR(a.getLocation(), radius);
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueNexusBot) <= radius && BblueNexusBot == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueTop1) <= radius && BblueTop1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueTop2) <= radius && BblueTop2 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueMid1) <= radius && BblueMid1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueMid2) <= radius && BblueMid2 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueBot1) <= radius && BblueBot1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(blueBot2) <= radius && BblueBot2 == true){
						a.setHealth(a.getHealth()-2.5);
					}
				}
				
				for(Player a : Var.blue){
					if(a.getLocation().distance(redNexusTop) <= radius && BredNexusTop == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redNexusBot) <= radius && BredNexusBot == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redTop1) <= radius && BredTop1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redTop2) <= radius && BredTop2 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redMid1) <= radius && BredMid1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redMid2) <= radius && BredMid2 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redBot1) <= radius && BredBot1 == true){
						a.setHealth(a.getHealth()-2.5);
					}else if(a.getLocation().distance(redBot2) <= radius && BredBot2 == true){
						a.setHealth(a.getHealth()-2.5);
					}
				}
				
			}
		}, 0, 20*5);
		
		
	}

	public Location getRedNexusTop() {
		return redNexusTop;
	}

	public Location getRedNexusBot() {
		return redNexusBot;
	}

	public Location getRedTop1() {
		return redTop1;
	}

	public Location getRedTop2() {
		return redTop2;
	}

	public Location getRedMid1() {
		return redMid1;
	}

	public Location getRedMid2() {
		return redMid2;
	}

	public Location getRedBot1() {
		return redBot1;
	}

	public Location getRedBot2() {
		return redBot2;
	}

	public Location getBlueNexusTop() {
		return blueNexusTop;
	}

	public Location getBlueNexusBot() {
		return blueNexusBot;
	}

	public Location getBlueTop1() {
		return blueTop1;
	}

	public Location getBlueTop2() {
		return blueTop2;
	}

	public Location getBlueMid1() {
		return blueMid1;
	}

	public Location getBlueMid2() {
		return blueMid2;
	}

	public Location getBlueBot1() {
		return blueBot1;
	}

	public Location getBlueBot2() {
		return blueBot2;
	}
	
	
	
}
