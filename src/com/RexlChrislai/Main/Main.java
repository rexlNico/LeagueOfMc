package com.RexlChrislai.Main;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.RexlChrislai.Api.Factory;
import com.RexlChrislai.Api.MySQL;
import com.RexlChrislai.Api.Var;
import com.RexlChrislai.Attack.Manager;
import com.RexlChrislai.Champions.ChampionManager;
import com.RexlChrislai.Gamestate.Gamestate;
import com.RexlChrislai.Gamestate.GamestateHandler;
import com.RexlChrislai.Listeners.Build;
import com.RexlChrislai.Listeners.Lobby;
import com.RexlChrislai.commands.MainCommand;
import com.RexlChrislai.commands.setMinionSpawn;
import com.google.common.reflect.ClassPath;

public class Main extends JavaPlugin{

	private static Main plugin;
	public static MySQL mysql;
	public static ChampionManager cm;
	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		mysql = new MySQL();
		mysql.connect();
		plugin = this;
		cm = new ChampionManager();
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§4LoM §aGeladen");
		Bukkit.getConsoleSender().sendMessage(" ");
		loadListeners();
		
		getCommand("setminionspawn").setExecutor(new setMinionSpawn());
		getCommand("lom").setExecutor(new MainCommand());
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		new GamestateHandler();
		GamestateHandler.setGameState(Gamestate.LOBBY_STATE);
		removeItems();
		new Manager();
		mysql.execute("CREATE TABLE IF NOT EXISTS `Lom` (UUID varchar(15), Name varchar(15), leaverbuster int(1), leaverbusterTIME int(3), kills int(5), deaths int(5), distroyedTower int(5), distroyedNexus int(5), playedGames int(5))");
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void onDisable() {
		mysql.close();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	
    private void loadListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
       pluginManager.registerEvents(new Manager(), this);
        try {
            for (ClassPath.ClassInfo classInfo : ClassPath.from(getClassLoader()).getTopLevelClasses("com.RexlChrislai.Listeners")) {
                @SuppressWarnings("rawtypes")
				Class clazz = Class.forName(classInfo.getName());
                if (Listener.class.isAssignableFrom(clazz)) {
                    pluginManager.registerEvents((Listener) clazz.newInstance(), this);
                }
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    
	private void removeItems(){
		World world = Factory.getConfigLocation("Nexus.red", Var.cfg).getWorld();
		List<Entity> entities = world.getEntities();
		for(Entity items : entities){
			if(!(items instanceof Player)){
				items.remove();
			}
		}
	}
	
}
