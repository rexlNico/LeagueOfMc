package com.RexlChrislai.Attack;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Attack {

	public abstract void Listener(PlayerInteractEvent e);

	public abstract void q(Player p);

	public abstract void w(Player p);

	public abstract void e(Player p);

	public abstract void r(Player p);
	
	
}
