package com.RexlChrislai.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEvent implements Listener{

	@EventHandler
	public void on(ServerListPingEvent e) {
		e.setMotd("Waiting");
	}
	
}
