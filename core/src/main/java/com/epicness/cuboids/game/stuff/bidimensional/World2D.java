package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class World2D implements Drawable2D {

    private final Rectangle[] rectangles;
    private final RectanglePlus[] tests;
    private final Player player;

    public World2D() {
        rectangles = new Rectangle[6];
        rectangles[0] = new Rectangle(0, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        rectangles[1] = new Rectangle(CAMERA_WIDTH, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        rectangles[2] = new Rectangle(-CAMERA_WIDTH, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        rectangles[3] = new Rectangle(CAMERA_WIDTH * 2f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        rectangles[4] = new Rectangle(0f, CAMERA_HEIGHT, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);
        rectangles[5] = new Rectangle(0f, -CAMERA_HEIGHT, CAMERA_WIDTH, CAMERA_HEIGHT, 25f, WHITE, CLEAR);

        tests = new RectanglePlus[3];
        tests[0] = new RectanglePlus(-700f, 300f, 400f, 400f, RED);
        tests[1] = new RectanglePlus(1300f, 300f, 400f, 400f, GREEN);
        tests[2] = new RectanglePlus(1300f, 1300f, 400f, 400f, YELLOW);

        player = new Player();
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].draw(shapeDrawer);
        }
        for (int i = 0; i < tests.length; i++) {
            tests[i].draw(shapeDrawer);
        }
        player.draw(shapeDrawer);
    }

    public Rectangle[] getRectangles() {
        return rectangles;
    }

    public RectanglePlus[] getTests() {
        return tests;
    }

    public Player getPlayer() {
        return player;
    }
}