package com.RexlChrislai.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Factory;
import com.RexlChrislai.Api.Var;

public class setMinionSpawn implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lable, String[] args) {
		
		Player p = (Player)s;
		
		if(args.length == 2){
			int i = Integer.parseInt(args[1]);
			if(i < 1 || i > 3){
				p.sendMessage("setminionspawn <rot/blau> <1-3>");
			}
			if(args[0].equalsIgnoreCase("rot")){
				Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Minions.red."+i);
			}else if(args[0].equalsIgnoreCase("blau")){
				Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file,"Minions.blue."+i);
			}else{
				p.sendMessage("setminion <rot/blau>");
			}
		}else{
			p.sendMessage("setminionspawn <rot/blau> <1-3>");
		}
		
		return false;
	}

}
