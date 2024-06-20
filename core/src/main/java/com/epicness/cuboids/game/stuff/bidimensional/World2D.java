package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class World2D implements Drawable2D {

    private final Rectangle rectangle;
    private final Player player;

    public World2D(SharedAssets sharedAssets) {
        rectangle = new Rectangle(0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        player = new Player();
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        rectangle.draw(shapeDrawer);
        player.draw(shapeDrawer);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Player getPlayer() {
        return player;
    }
}