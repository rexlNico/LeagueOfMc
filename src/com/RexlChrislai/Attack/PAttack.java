package com.RexlChrislai.Attack;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.ItemBuilder;
import com.RexlChrislai.Main.Main;

public class PAttack {

	private int taskID1, taskID2, taskID3, taskID4;
	
	private int i1, i2, i3, i4;
	
	private Player p;
	private int Mana;
	private double qMana;
	private double wMana;
	private double eMana;
	private double rMana;
	private double qCooldown;
	private double wCooldown;
	private double eCooldown;
	private double rCooldown;
	
	public PAttack(Player p, int Mana, double qManaCost, double wManaCost, double eManaCost, double rManaCost, double qCooldown, double wCooldown, double eCooldown, double rCooldown) {
		this.p = p;
		this.Mana = Mana; 
		this.qMana = qManaCost;
		this.wMana = qManaCost;
		this.eMana = eManaCost;
		this.rMana = rManaCost;
		this.qCooldown = qCooldown;
		this.wCooldown = wCooldown;
		this.eCooldown = eCooldown;
		this.rCooldown = rCooldown;
	}
	
	public boolean cooldownQ(){
		if(!ManaM.mana.containsKey(p) || Integer.valueOf(ManaM.mana.get(p)) >= (int) (qMana)) {
			return false;
		}
		p.getInventory().setItem(0, null);
		taskID1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			@Override
			public void run() {
				i1++;
				if(i1 == qCooldown){
					i1 = 0;
					p.getInventory().setItem(0, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 1).setName("§1Q").build());
					Bukkit.getScheduler().cancelTask(taskID1);
				}
			}
		}, 0, 20*1);
		return true;
	}
	
	public double getqMana() {
		return qMana;
	}

	public int getMana() {
		return Mana;
	}

	public void setMana(int mana) {
		Mana = mana;
	}

	public void setqMana(double qMana) {
		this.qMana = qMana;
	}

	public double getwMana() {
		return wMana;
	}

	public void setwMana(double wMana) {
		this.wMana = wMana;
	}

	public double geteMana() {
		return eMana;
	}

	public void seteMana(double eMana) {
		this.eMana = eMana;
	}

	public double getrMana() {
		return rMana;
	}

	public void setrMana(double rMana) {
		this.rMana = rMana;
	}

	public double getqCooldown() {
		return qCooldown;
	}

	public void setqCooldown(double qCooldown) {
		this.qCooldown = qCooldown;
	}

	public double getwCooldown() {
		return wCooldown;
	}

	public void setwCooldown(double wCooldown) {
		this.wCooldown = wCooldown;
	}

	public double geteCooldown() {
		return eCooldown;
	}

	public void seteCooldown(double eCooldown) {
		this.eCooldown = eCooldown;
	}

	public double getrCooldown() {
		return rCooldown;
	}

	public void setrCooldown(double rCooldown) {
		this.rCooldown = rCooldown;
	}

	public boolean cooldownW(){
		if(!ManaM.mana.containsKey(p) || Integer.valueOf(ManaM.mana.get(p)) >= (int) (wMana)) {
			return false;
		}
		p.getInventory().setItem(1, null);
		taskID2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			@Override
			public void run() {
				i2++;
				if(i2 == wCooldown){
					i2 = 0;
					p.getInventory().setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 2).setName("§1W").build());
					Bukkit.getScheduler().cancelTask(taskID2);
				}
			}
		}, 0, 20*1);
		return true;
	}

	public boolean cooldownE(){
		if(!ManaM.mana.containsKey(p) || Integer.valueOf(ManaM.mana.get(p)) >= (int) (eMana)) {
			return false;
		}
		p.getInventory().setItem(0, null);
		taskID3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			@Override
			public void run() {
				i3++;
				if(i3 == eCooldown){
					i3 = 0;
					p.getInventory().setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 3).setName("§1E").build());
					Bukkit.getScheduler().cancelTask(taskID3);
				}
			}
		}, 0, 20*1);
		return true;
	}

	public boolean cooldownR(){
		if(!ManaM.mana.containsKey(p) || Integer.valueOf(ManaM.mana.get(p)) >= (int) (rMana)) {
			return false;
		}
		p.getInventory().setItem(0, null);
		taskID4 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			@Override
			public void run() {
				i4++;
				if(i4 == rCooldown){
					i4 = 0;
					p.getInventory().setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 4).setName("§1R").build());
					Bukkit.getScheduler().cancelTask(taskID4);
				}
			}
		}, 0, 20*1);
		return true;
	}
	
}
