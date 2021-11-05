package com.RexlChrislai.Champions;

import org.bukkit.inventory.ItemStack;

import com.RexlChrislai.Attack.Attack;

public class Champion {

	public String name;
	public ItemStack guiItem;
	public int maxHealth;
	public int maxMana;
	private double qMana;
	private double wMana;
	private double eMana;
	private double rMana;
	private double qCooldown;
	private double wCooldown;
	private double eCooldown;
	private double rCooldown;
	private Attack attack;
	
	
	public Champion(Attack attack, String name, ItemStack guiItem, int maxHealth, int maxMana, double qManaCost, double wManaCost, double eManaCost, double rManaCost, double qCooldown, double wCooldown, double eCooldown, double rCooldown) {
		this.name = name;
		this.guiItem = guiItem;
		this.maxHealth = maxHealth;
		this.maxMana = maxMana;
		this.qMana = qManaCost;
		this.wMana = qManaCost;
		this.eMana = eManaCost;
		this.rMana = rManaCost;
		this.qCooldown = qCooldown;
		this.wCooldown = wCooldown;
		this.eCooldown = eCooldown;
		this.rCooldown = rCooldown;
		this.attack = attack;
	}


	
	
	public Attack getAttack() {
		return attack;
	}




	public void setAttack(Attack attack) {
		this.attack = attack;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public ItemStack getguiItem() {
		return guiItem;
	}


	public void setguiItem(ItemStack guiItem) {
		this.guiItem = guiItem;
	}
	public int getMaxHealth() {
		return maxHealth;
	}


	public int getMaxMana() {
		return maxMana;
	}


	public double getqMana() {
		return qMana;
	}


	public double getwMana() {
		return wMana;
	}


	public double geteMana() {
		return eMana;
	}


	public double getrMana() {
		return rMana;
	}


	public double getqCooldown() {
		return qCooldown;
	}


	public double getwCooldown() {
		return wCooldown;
	}


	public double geteCooldown() {
		return eCooldown;
	}


	public double getrCooldown() {
		return rCooldown;
	}
	
}
