package com.RexlChrislai.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.RexlChrislai.Api.Factory;
import com.RexlChrislai.Api.Var;

public class MainCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission("Lom.setspawn")){
				if(args.length == 0){
					p.sendMessage("§7---§eHilfe§7---");
					p.sendMessage("");
					p.sendMessage("§7/lom §esetlobby");
					p.sendMessage("§7/lom §esetspawn §7<§4red§7/§1blue§7>");
					p.sendMessage("§7/lom §esetNexus §7<§4red§7/§1blue§7>");
					p.sendMessage("§7/lom §esetNexusTower §7<§4red§7/§1blue§7> <§5top§7/§5bot§7>");
					p.sendMessage("§7/lom §esetTower §7<§4red§7/§1blue§7> <§5top§7/§5mid§7/§5bot§7> <§61§7/§62§7>");
					p.sendMessage("§7/lom §esetInhibitor §7<§4red§7/§1blue§7> <§5top§7/§5mid§7/§5bot§7>");
					p.sendMessage("");
					p.sendMessage("§7---§eHilfe§7---");
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("setlobby")){
						Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Spawn.Lobby");
						p.sendMessage(Var.pr+"§7Du hast den Spawn für die Lobby gesetzt.");
					}
				}else if(args.length == 2){
					if(args[0].equalsIgnoreCase("setspawn")){
						if(args[1].equalsIgnoreCase("red")){
							Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Spawn.red");
							p.sendMessage(Var.pr+"§7Du hast den Spawn für Rot gesetzt.");
						}else if(args[1].equalsIgnoreCase("blue")){
							Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Spawn.blue");
							p.sendMessage(Var.pr+"§7Du hast den Spawn für Blau gesetzt.");
						}
					}else if(args[0].equalsIgnoreCase("setnexus")){
						if(args[1].equalsIgnoreCase("red")){
							Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Nexus.red");
							p.sendMessage(Var.pr+"§7Du hast den Nexus für Rot gesetzt.");
						}else if(args[1].equalsIgnoreCase("blue")){
							Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Nexus.blue");
							p.sendMessage(Var.pr+"§7Du hast den Nexus für Blau gesetzt.");
						}
					}
				}else if(args.length == 3){
					if(args[0].equalsIgnoreCase("setNexustower")){
						if(args[1].equalsIgnoreCase("red")){
							if(args[2].equalsIgnoreCase("top")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.red.nexus.top");
								p.sendMessage(Var.pr+"§7Du hast den Nexustower für Rot auf Top gesetzt.");
							}else if(args[2].equalsIgnoreCase("bot")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.red.nexus.bot");
								p.sendMessage(Var.pr+"§7Du hast den Nexustower für Rot auf Bot gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("blue")){
							if(args[2].equalsIgnoreCase("top")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.blue.nexus.top");
								p.sendMessage(Var.pr+"§7Du hast den Nexustower für Blau auf Top gesetzt.");
							}else if(args[2].equalsIgnoreCase("bot")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.blue.nexus.bot");
								p.sendMessage(Var.pr+"§7Du hast den Nexustower für Blau auf Bot gesetzt.");
							}
						}
					}else if(args[0].equalsIgnoreCase("setInhibitor")){
						if(args[1].equalsIgnoreCase("red")){
							if(args[2].equalsIgnoreCase("top")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.red.top");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Rot auf Top gesetzt.");
							}else if(args[2].equalsIgnoreCase("mid")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.red.mid");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Rot auf Mid gesetzt.");
							}else if(args[2].equalsIgnoreCase("bot")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.red.bot");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Rot auf Bot gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("blue")){
							if(args[2].equalsIgnoreCase("top")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.blue.top");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Blau auf Top gesetzt.");
							}else if(args[2].equalsIgnoreCase("mid")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.blue.mid");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Blau auf Mid gesetzt.");
							}else if(args[2].equalsIgnoreCase("bot")){
								Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Inhibitor.blue.bot");
								p.sendMessage(Var.pr+"§7Du hast den Inhibitor für Blau auf Bot gesetzt.");
							}
						}
					}
				}else if(args.length == 4){
					if(args[0].equalsIgnoreCase("setTower")){
						if(args[1].equalsIgnoreCase("red")){
							if(args[2].equalsIgnoreCase("top")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.red.top."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Rot auf Top gesetzt.");
								}
							}else if(args[2].equalsIgnoreCase("mid")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.red.mid."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Rot auf Mid gesetzt.");
								}
							}else if(args[2].equalsIgnoreCase("bot")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.red.bot."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Rot auf Bot gesetzt.");
								}
							}
						}else if(args[1].equalsIgnoreCase("blue")){
							if(args[2].equalsIgnoreCase("top")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.blue.top."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Blau auf Top gesetzt.");
								}
							}else if(args[2].equalsIgnoreCase("mid")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.blue.mid."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Blau auf Mid gesetzt.");
								}
							}else if(args[2].equalsIgnoreCase("bot")){
								if(args[3].equals("1") || args[3].equals("2")){
									Factory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, "Tower.blue.bot."+args[3]);
									p.sendMessage(Var.pr+"§7Du hast den Tower "+args[3]+" für Blau auf Bot gesetzt.");
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

}
