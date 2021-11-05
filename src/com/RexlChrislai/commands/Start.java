package com.RexlChrislai.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Gamestate.Lobby_STATE;

public class Start implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission("lol.start")){
				if(args.length == 0){
					if(GamestateHandler.getGamestate() instanceof Lobby_STATE){
						Lobby_STATE ls = (Lobby_STATE) GamestateHandler.getGamestate();
						if(ls.getCountdown().getSec() > 10){
							ls.getCountdown().setSec(6);
							p.sendMessage(Var.pr+"§aDu hast die Wartezeit beschleunigt!");
						}else{
							p.sendMessage(Var.pr+"§cDas Spiel startet bereits");
						}
					}
				}
			}
		}
		return false;
	}

}
