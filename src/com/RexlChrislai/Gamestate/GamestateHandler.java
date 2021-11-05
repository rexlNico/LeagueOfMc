package com.RexlChrislai.Gamestate;

import java.util.ArrayList;

public class GamestateHandler {

	private static Gamestate current;
	private static ArrayList<Gamestate> state = new ArrayList<>();
	
	public GamestateHandler(){
		state.add(new Lobby_STATE());
		state.add(new Ingame_STATE());
		state.add(new End_STATE());
	}
	
	public static void setGameState(int id){
		if(current != null) current.end();
		current = state.get(id);
		current.init();
	}
	
	public static Gamestate getGamestate(){
		return current;
	}
	
}
