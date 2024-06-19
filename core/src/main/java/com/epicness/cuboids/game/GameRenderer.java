package com.epicness.cuboids.game;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.epicness.cuboids.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer3D;

public class GameRenderer extends Renderer3D<GameStuff> {

    @Override
    public void render() {
        clearDepth(CLEAR);

        spriteBatch.begin();
        stuff.getWorld3D().draw2D(spriteBatch, shapeDrawer, screen.getDynamicCamera());
        spriteBatch.end();

        modelBatch.begin(perspectiveCamera);
        stuff.getWorld3D().draw3D(modelBatch);
        modelBatch.end();

        useStaticCamera();
        spriteBatch.begin();
        stuff.getWorld2D().getRectangle().draw(shapeDrawer);
        spriteBatch.end();
    }
}