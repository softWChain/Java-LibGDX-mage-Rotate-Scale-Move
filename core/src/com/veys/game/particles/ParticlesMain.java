package com.veys.game.particles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.veys.game.Game;

public class ParticlesMain {
	
	public  ArrayList<Particle> particles;
	
	public ParticlesMain() {
		particles = new ArrayList<Particle>();
	}
	
	
	public void tick(float dt) {
		for(Particle p : particles) {
			p.tick(dt);
		}
		
	}
	
	public void render(ShapeRenderer sr) {
		for(Particle p:particles) {
			p.render(sr);
		}
	}
	
	public void addParticles(Particle part) {
		this.particles.add(part);
	}
	
	public void removeParticles(Particle part) {
		this.particles.remove(part);
	}
	



}
