package com.mygdx.memorygame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by lixiaoyan on 6/22/18.
 */

public class MainMenuScreen implements Screen {
    final MemoryGame game;
    OrthographicCamera camera;


    public MainMenuScreen(final MemoryGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.getData().setScale(2f);
        game.font.draw(game.batch, "This is memory game", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin :)", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void show(){}

    @Override
    public void hide(){}

    @Override
    public void resize(int x, int y){}

    @Override
    public void pause(){}

    @Override
    public void resume(){}


    @Override
    public void dispose(){}

}
