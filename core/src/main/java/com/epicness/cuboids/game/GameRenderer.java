package com.epicness.cuboids.game;

import static com.badlogic.gdx.graphics.Color.CLEAR;

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
        drawArray(stuff.getLives());
        stuff.getWaveText().draw(spriteBatch);
        stuff.getFreeMovementText().draw(spriteBatch);
        stuff.getInstructionsText().draw(spriteBatch);
        spriteBatch.end();
    }
}