package com.veys.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.veys.game.Game;
import com.veys.game.iu.Graphic;
import com.veys.game.managers.GSM;
import com.veys.game.particles.ActorMotion;

public class MenuState extends GameState{
	
	private Graphic title;
	public static Texture text;
	private TextureRegion textRegion;
	private ShapeRenderer sr;
	private ActorMotion e1,e2;
	
	public MenuState(GSM gsm) {
		super(gsm);
		sr = new ShapeRenderer();
		text = new Texture(Gdx.files.internal("menu1.png"));
		textRegion = new TextureRegion(text);
		textRegion.flip(false, true);
		title = new Graphic(textRegion,
				Game.WIDTH/2,
				Game.HEIGHT/2 - 100);
		
		
		e1 = new ActorMotion(text);
		e1.setOrigin(e1.getWidth()/2, e1.getHeight()/2);
		e1.setPosition(Game.WIDTH/2-120, Game.HEIGHT/2-100);
		e1.setColor(e1.getColor().r, e1.getColor().g, e1.getColor().b, 0f);
		
		AlphaAction aa = new AlphaAction();
		aa.setDuration(5f);
		aa.setAlpha(1f);
		
		RotateByAction mta = new RotateByAction();
		mta.setDuration(2f);
		mta.setAmount(180);
		//mta.setInterpolation(Interpolation.exp10);
		e1.addAction(mta);
		
		ScaleByAction sba = new ScaleByAction();
		sba.setAmount(0.2f);
		sba.setDuration(3f);
		
		MoveToAction move = new MoveToAction();
		move.setDuration(3f);
		move.setPosition(30, Game.HEIGHT/2-100);
		
		
		ScaleByAction sba1 = new ScaleByAction();
		sba1.setAmount(-3f);
		sba1.setDuration(3f);
		
		MoveToAction move1 = new MoveToAction();
		move1.setPosition(Game.WIDTH/2-150, Game.HEIGHT/2-100);
		move1.setDuration(3f);
		
		MoveToAction move2 = new MoveToAction();
		move2.setDuration(3f);
		move2.setPosition(0, Game.HEIGHT/2-100);
		
		RotateByAction rotate1 = new RotateByAction();
		rotate1.setDuration(5f);
		rotate1.setAmount(8*360);
		rotate1.setInterpolation(Interpolation.bounceOut);
		//e1.addAction(rotate1);
		
		e1.setColor(e1.getColor().r, e1.getColor().g, e1.getColor().b, 0f);
		
		AlphaAction aa1 = new AlphaAction();
		aa1.setDuration(5f);
		aa1.setAlpha(0.09f);
		
		AlphaAction aa2 = new AlphaAction();
		aa2.setDuration(15f);
		aa2.setAlpha(5f);
		
		RotateByAction rotate2 = new RotateByAction();
		rotate2.setDuration(5f);
		rotate2.setAmount(180);
		
		ScaleByAction sba2 = new ScaleByAction();
		sba2.setDuration(5f);
		sba2.setAmount(-0.1f);

		
		ScaleByAction sba3 = new ScaleByAction();
		sba3.setDuration(3f);
		sba3.setAmount(5f);
		
		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			MoveToAction m = new MoveToAction();
			m.setDuration(0.5f);
			m.setPosition(0, -10f);
			e1.addAction(m);
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			MoveToAction m = new MoveToAction();
			m.setDuration(0.5f);
			m.setPosition(0, 30f);
			e1.addAction(m);
		}

		
		e1.addAction(new SequenceAction(aa,mta,sba,move,
				new SequenceAction(new ParallelAction(sba1,move1,aa1),
						new ParallelAction(sba1,move1,rotate1),new ParallelAction(aa2,rotate2),sba2,sba3)));
		


	
	}
	
	public void hareketEt() {
		e1.act(Gdx.graphics.getDeltaTime());
		
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			
			RotateByAction rotate1 = new RotateByAction();
			rotate1.setDuration(5f);
			rotate1.setAmount(8*360);
			rotate1.setInterpolation(Interpolation.bounceOut);
			e1.addAction(rotate1);
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.D)) {
			RotateByAction rotate2 = new RotateByAction();
			rotate2.setDuration(1f);
			rotate2.setAmount(180);
			e1.addAction(rotate2);
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.A)) {
			RotateByAction rotate2 = new RotateByAction();
			rotate2.setDuration(1f);
			rotate2.setAmount(-180);
			e1.addAction(rotate2);
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.W)) {
			ScaleByAction sba2 = new ScaleByAction();
			sba2.setDuration(2f);
			sba2.setAmount(-2f);
			e1.addAction(sba2);
		}
		if(Gdx.input.isKeyJustPressed(Keys.S)) {
			ScaleByAction sba2 = new ScaleByAction();
			sba2.setDuration(2f);
			sba2.setAmount(2f);
			e1.addAction(sba2);
		}

		
		

	}


	public void tick(float dt) {
		hareketEt();
		
	}

	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);

		sb.begin();
		//title.render(sb);
		e1.draw(sb, 1.0f);
		sb.end();
		
		
		sr.begin(ShapeRenderer.ShapeType.Line);
		//sr.setColor(Color.WHITE);
		//sr.line(Game.WIDTH/2, 0,Game.WIDTH/2,Game.HEIGHT);
		
		sr.setColor(Color.RED);
		//sr.rect(0, 0, 30, 30);
		sr.end();
	}

	public void HandlerInput() {

		
	}

	public void dispose() {
	
		
	}
	

}
