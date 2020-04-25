package com.veys.game.particles;



import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.veys.game.Game;
import com.veys.game.states.GameState;

public class Particle {
	
	private float x;
	private float y;
	private float velX,velY;
	protected Color color;
	private Random r = new Random();
	private ParticlesMain mainP;



	
	public Particle(float x,float y) {
		this.x=x;
		this.y=y;
		//setVelX(r.nextInt(5)+1);
		setVelY(MathUtils.random(-10, 10));
		setVelX(MathUtils.random(-10, 10));
		mainP = new ParticlesMain();

		
	}
	
	public void tick(float dt) {
		x +=velX;
		y += velY;
		color = new Color(r.nextInt(25),r.nextInt(25),r.nextInt(3),r.nextInt(3));
		/*
		if(x<0 && velX<0) velX = -velX;
		if(x>Game.WIDTH - 12 && velX>0) velX = -velX;
		if(y<0 && velY<0) velY = -velY;
		if(y>Game.HEIGHT -12 && velY>0) velY = -velY;
		*/
		
		if(x<0 ) x = 0;
		if(y<0)  y = 0;
		
		if(y > Game.HEIGHT-14) y = Game.HEIGHT-14;
		
		if(x > Game.WIDTH -14) x = Game.WIDTH -14;

		
		
		
		
	}
	
	public void render(ShapeRenderer sr) {

		sr.setProjectionMatrix(GameState.cam.combined);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(color);
		sr.rect((int)x, (int)y, 12, 12);
		sr.end();

	}
	
	public void setVelX(float velX) { this.velX = velX;}
	public void setVelY(float velY) { this.velY = velY;}
	public float getX() { return x;}
	public float getY() { return y;}
	public float getVelX() { return velX;}
	public float getVelY() { return velY;}

	

}
