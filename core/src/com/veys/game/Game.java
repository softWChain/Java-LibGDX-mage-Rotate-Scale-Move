package com.veys.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.veys.game.managers.GSM;
import com.veys.game.particles.Particle;
import com.veys.game.particles.ParticlesMain;
import com.veys.game.states.GameState;
import com.veys.game.states.MenuState;

public class Game extends ApplicationAdapter {
	
	public static final int WIDTH = 1080;
	public static final int HEIGHT = 400;
	public static final String TITLE  = "VEYS";
	
	
	private SpriteBatch sb;
	private GSM gsm;
	private ParticlesMain part;
	private ShapeRenderer sr;
	private int ticks=0;

	@Override
	public void create () {

	
		gsm = new GSM();
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		part = new ParticlesMain();
		gsm.push(new MenuState(gsm));
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.setProjectionMatrix(GameState.cam.combined);
		gsm.tick(Gdx.graphics.getDeltaTime());
		part.tick(Gdx.graphics.getDeltaTime()*0.0005f);
		gsm.render(sb);
		part.render(sr);
		ticks++;
		HandleInput();
		
		if(ticks>=61) {
			ticks = 0;
		}
		
		
		for(Particle p : part.particles) {
			if(p.getY() >= Game.HEIGHT -14 || p.getX() >= Game.WIDTH -14||
					p.getX()<=0 || p.getY()<=0) {
				if(ticks%1==0) {
					part.removeParticles(p);
					return;
				}

			}
			else if(p.getVelX() == 0 || p.getVelY()==0||
					p.getVelX() == -1 || p.getVelY() == -1||
					p.getVelX() == 1 || p.getVelY() == 1) {
				part.removeParticles(p);
				return;
			}
		}
		

		
		
	}
	
	
	public void HandleInput() {
		
		GameState.mouse.x = Gdx.input.getX();
		GameState.mouse.y = Gdx.input.getY();
		GameState.cam.unproject(GameState.mouse);
		
		if(Gdx.input.isTouched(0)) {
			
			part.particles.add(new Particle(GameState.mouse.x - 6,
					GameState.mouse.y - 6));
			part.particles.add(new Particle(GameState.mouse.x - 6,
					GameState.mouse.y - 6));
			part.particles.add(new Particle(GameState.mouse.x - 6,
					GameState.mouse.y - 6));
			part.particles.add(new Particle(GameState.mouse.x - 6,
					GameState.mouse.y - 6));
		}

		
	}
	
	@Override
	public void dispose () {
		MenuState.text.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		GameState.viewport.update(width, height);
		GameState.cam.position.set(GameState.cam.viewportWidth/2,
				GameState.cam.viewportHeight/2,0);
	}
	
	
	
	
}
