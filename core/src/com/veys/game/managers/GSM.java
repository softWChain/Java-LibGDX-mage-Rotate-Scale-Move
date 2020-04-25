package com.veys.game.managers;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.veys.game.states.GameState;

public class GSM {
	
	
	public Stack<GameState> state;
	
	public GSM() {
		state = new Stack<GameState>();
	}
	
	public void tick(float dt) {
		this.state.peek().tick(dt);
	}
	public void render(SpriteBatch sb) {
		this.state.peek().render(sb);
	}
	
	public void push(GameState state) {
		this.state.push(state);
	}
	public void pop() {
		this.state.pop();
	}
	
	public void setState(GameState state) {
		this.state.push(state);
		this.state.pop();
	}

}
