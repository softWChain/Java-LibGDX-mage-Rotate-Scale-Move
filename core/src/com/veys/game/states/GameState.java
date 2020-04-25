package com.veys.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.veys.game.Game;
import com.veys.game.managers.GSM;

public abstract class GameState {
	
	public static OrthographicCamera cam;
	public GSM gsm;
	public static Vector3 mouse;
	public static Viewport viewport;
	
	public GameState(GSM gsm) {
		this.gsm=gsm;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, Gdx.graphics.getWidth()
				, Gdx.graphics.getHeight());
		cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2,0);
		
		
		viewport = new FitViewport(Game.WIDTH,Game.HEIGHT);
		viewport.setCamera(cam);
		viewport.apply();
		
		mouse = new Vector3();
		
	}
	
	
	public abstract void tick(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void HandlerInput();
	public abstract void dispose();
	
}
