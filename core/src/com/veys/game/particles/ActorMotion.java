package com.veys.game.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.veys.game.Game;

public class ActorMotion extends Actor{
	
	Texture texture;
	
	
	public ActorMotion(Texture texture) {
		this.texture = texture;
		setSize(texture.getWidth(), texture.getHeight());
	}
	
    @Override
    public void draw(Batch batch, float alpha){
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * alpha);
        batch.draw(texture,this.getX() ,getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
                this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
                texture.getWidth(),texture.getHeight(),false,false);
        batch.setColor(color.r, color.g, color.b, color.a * 1.0f);
    } 


	

}
