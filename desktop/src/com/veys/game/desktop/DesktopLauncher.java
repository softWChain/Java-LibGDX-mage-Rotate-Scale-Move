package com.veys.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.veys.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = Game.TITLE;
		config.width = Game.WIDTH;
		config.height = Game.HEIGHT;

		
		new LwjglApplication(new Game(), config);
	}
}
