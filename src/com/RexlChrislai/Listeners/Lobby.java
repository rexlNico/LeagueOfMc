package com.RexlChrislai.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.RexlChrislai.Api.ItemBuilder;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Champions.Champion;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Gamestate.Lobby_STATE;
import com.RexlChrislai.Main.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Lobby implements Listener{

	@SuppressWarnings("static-access")
	@EventHandler
	public void onP(PlayerInteractEvent e){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				Player p = e.getPlayer();
				
				if(p.getItemInHand().getType().equals(Material.SLIME_BALL)){
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
					ByteArrayDataOutput out = ByteStreams.newDataOutput();
					out.writeUTF("Connect");
					out.writeUTF("lobby-01");
					p.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
				}else if(p.getItemInHand().getType().equals(Material.PAPER)){
					Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§aTeam wählen");
					for(int i = 0; i<5; i++){
						inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
					}
					String r = "";
					String b = "";
					for(Player a : Var.red){
						r = r+"§7» §4"+a.getName()+"/n";
					}
					for(Player a : Var.blue){
						b = b+"§7» §1"+a.getName()+"/n";
					}
					inv.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 11).setName("§1Blau").setLore(b).build());
					inv.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§4Rot").setLore(r).build());
					p.openInventory(inv);
				}else if(p.getItemInHand().getType().equals(Material.BANNER)){
					Main.cm.openInv(p);
			}
		}
	}
	
	@EventHandler
	public void onE(EntityDamageEvent e){
		if(e.getEntity().getType() == EntityType.ARMOR_STAND){
			e.setCancelled(true);
		}
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onI(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		if(e.getInventory().getName().equals("§aTeam wählen")){
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§1Blau")){
				if(Var.red.contains(p)) Var.red.remove(p);
				if(!Var.blue.contains(p)) Var.blue.add(p);
				Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§aTeam wählen");
				for(int i = 0; i<5; i++){
					inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
				}
				String r = "";
				String b = "";
				for(Player a : Var.red){
					r = r+"§7» §4"+a.getName()+"/n";
				}
				for(Player a : Var.blue){
					b = b+"§7» §1"+a.getName()+"/n";
				}
				inv.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 11).setName("§1Blau").setLore(b).build());
				inv.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§4Rot").setLore(r).build());
				p.closeInventory();
				p.openInventory(inv);
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Rot")){
				if(Var.blue.contains(p)) Var.blue.remove(p);
				if(!Var.red.contains(p)) Var.red.add(p);
				Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§aTeam wählen");
				for(int i = 0; i<5; i++){
					inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
				}
				String r = "";
				String b = "";
				for(Player a : Var.red){
					r = r+"§7» §4"+a.getName()+"/n";
				}
				for(Player a : Var.red){
					b = b+"§7» §1"+a.getName()+"/n";
				}
				inv.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 11).setName("§1Blau").setLore(b).build());
				inv.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§4Rot").setLore(r).build());
				p.closeInventory();
				p.openInventory(inv);
			}
		}else if(e.getInventory().getName().equals("§aChampion auswahl")){
			String name = e.getCurrentItem().getItemMeta().getDisplayName().replace("§a", "").replace("§2", "");
			
			for(Champion c : Main.cm.champions){
				if(c.getName().equalsIgnoreCase(name)){
					Main.cm.championwahl.put(p, c);
					p.sendMessage("§4Test");
					p.closeInventory();
				}
			}
			
			
			
		}
		
	}
	
}
