package com.RexlChrislai.Gamestate;

import com.RexlChrislai.Countdowns.LobbyCountdown;

public class Lobby_STATE extends Gamestate{

	private LobbyCountdown countdown;
	
	@Override
	public void init() {
		
		countdown = new LobbyCountdown();
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	public LobbyCountdown getCountdown(){
		return countdown;
		
	}

}
