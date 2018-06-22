package com.mygdx.memorygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


//public class MemoryGame extends ApplicationAdapter {
public class MemoryGame extends Game {
    SpriteBatch batch;
	//private Texture img;
    BitmapFont font;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
		/*batch = new SpriteBatch();
		font = new BitmapFont();
        font.setColor(Color.RED);
		//img = new Texture("badlogic.jpg");
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        //camera.setToOrtho(false, 480, 800);
        shapeRenderer.setProjectionMatrix(camera.combined);*/

	}

	@Override
	public void render () {
	    super.render();
		/*Gdx.gl.glClearColor(1, 1, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();


        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(0, 1, 1, 1);
        shapeRenderer.rect(100, 100, 200, 100);
        shapeRenderer.end();

        batch.begin();
        //batch.draw(img, 0, 0);
        //stackoverflow.com/questions/33633395
        font.getData().setScale(5f);
        font.draw(batch, "Loading", 250, 250);
        batch.end();*/
	}
	
	@Override
	public void dispose () {

        batch.dispose();
        font.dispose();
		//img.dispose();
        //shapeRenderer.dispose();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
