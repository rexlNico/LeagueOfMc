package com.RexlChrislai.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.RexlChrislai.Api.NexusApi;
import com.RexlChrislai.Api.Tower;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Gamestate.Ingame_STATE;

public class DamageBuildings implements Listener{
	
	private NexusApi nexusAPI = Ingame_STATE.nexusAPI;
	private Tower towerAPI = Ingame_STATE.towerAPI;
	
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			
			if(GamestateHandler.getGamestate() instanceof Ingame_STATE){
				
				//Nexus
				if(e.getClickedBlock().getLocation().equals(nexusAPI.getBlue())){
					if(Var.red.contains(p)){
						nexusAPI.damageNexus(25, "blue");
					}
				}else if(e.getClickedBlock().getLocation().equals(nexusAPI.getRed())){
					if(Var.blue.contains(p)){
						nexusAPI.damageNexus(25, "red");
					}
				}
				 // Tower Blue
//				else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueBot1())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueBot1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueBot2())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueBot2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueMid1())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueMid1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueMid2())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueMid2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueTop1())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueTop1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueTop2())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueTop2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueNexusBot())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueNexusBot());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getBlueNexusTop())){
//					if(Var.red.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getBlueNexusTop());;
//					}
//				}
//				
//				//Tower Red 
//				else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedBot1())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedBot1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedBot2())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedBot2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedMid1())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedMid1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedMid2())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedMid2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedTop1())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedTop1());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedTop2())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedTop2());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedNexusBot())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedNexusBot());
//					}
//				}else if(e.getClickedBlock().getLocation().equals(towerAPI.getRedNexusTop())){
//					if(Var.blue.contains(p)){
//						towerAPI.damageTower(25, towerAPI.getRedNexusTop());;
//					}
//				}
				
				//Inhibitor
				
			}
		}
			
	}
	
}
