package com.RexlChrislai.Api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.RexlChrislai.Champions.Champion;

public class Var {

	public static File file = new File("plugins/lom/config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static ArrayList<Player> playing = new ArrayList<>();
	public static ArrayList<Player> red = new ArrayList<>();
	public static ArrayList<Player> blue = new ArrayList<>();
	
	public static String pr = "§8[§4LOM§8] §r";
	
	public static int MIN_PLAYERS = 2;
	
}
