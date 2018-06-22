package com.mygdx.memorygame;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import org.w3c.dom.css.Rect;

/**
 * Created by lixiaoyan on 6/22/18.
 */

public class GameScreen implements Screen {
    final MemoryGame game;
    private OrthographicCamera camera;
    private Rectangle[][] grid;
    private int numberOfBlocks;
    private ShapeRenderer shapeRenderer;

    public GameScreen(final MemoryGame game) {
        this.game = game;

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        numberOfBlocks=4;

        grid = new Rectangle[numberOfBlocks][numberOfBlocks];
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                Rectangle block = new Rectangle();
                block.width = 480/numberOfBlocks;
                block.height = 800/numberOfBlocks;
                block.x = i*block.width;
                block.y = j*block.height;
                grid[i][j] = block;
            }
        }
    }

    @Override
    public void render(float delta){
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.end();



        for(Rectangle[] row : grid){
            for(Rectangle block : row){
                shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
                shapeRenderer.setColor(0, 1, 1, 1);
                shapeRenderer.rect(block.x,block.y,block.getWidth(),block.getHeight());
                shapeRenderer.end();
            }
        }

        if(Gdx.input.isTouched()){
            Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(click);

            for(Rectangle[] row : grid){
                for(Rectangle block : row){

                    //TODO: figure out correct coordination translation
                    System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
                    if(inRectangle(block, Gdx.input.getX(), Gdx.input.getY())){
                        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                        shapeRenderer.setColor(0, 1, 1, 1);
                        shapeRenderer.rect(block.x,block.y,block.getWidth(),block.getHeight());
                        shapeRenderer.end();
                    }
                }
            }
        }


    }

    private boolean inRectangle(Rectangle rect, int x, int y){
        boolean xInside = (rect.x <= x) && (x <= rect.x + rect.getWidth());
        boolean yInside = (rect.y <= y) && (y <= rect.y + rect.getHeight());
        return xInside && yInside;
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

