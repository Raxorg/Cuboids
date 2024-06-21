package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.CYAN;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.OLIVE;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PINK;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.cuboids.game.GameConstants.BASE_RADIUS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;

public class World2D implements Drawable2D {

    private final LinePlus[] lines;
    private final RectanglePlus[] tests;
    private final Player player;
    private final CirclePlus base;

    public World2D() {
        lines = new LinePlus[12];
        // Top
        lines[0] = new LinePlus(0f, CAMERA_HEIGHT * 2f - 12.5f, CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, 25f, PURPLE);
        // Right
        lines[1] = new LinePlus(CAMERA_WIDTH * 2f - 12.5f, 0f, CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT, 25f, GREEN);
        // Top Right
        lines[2] = new LinePlus(CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, CAMERA_WIDTH * 2f, CAMERA_HEIGHT * 2f - 12.5f, 25f, YELLOW);
        lines[3] = new LinePlus(CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT * 2f, 25f, YELLOW);
        // Bottom
        lines[4] = new LinePlus(0f, -CAMERA_HEIGHT + 12.5f, CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, 25f, ORANGE);
        // Bottom Right
        lines[5] = new LinePlus(CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, CAMERA_WIDTH * 2f, -CAMERA_HEIGHT + 12.5f, 25f, CYAN);
        lines[6] = new LinePlus(CAMERA_WIDTH * 2f - 12.5f, -CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12.5f, 0f - 12.5f, 25f, CYAN);
        // Left
        lines[7] = new LinePlus(-CAMERA_WIDTH + 12.5f, 0f, -CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT, 25f, RED);
        // Top Left
        lines[8] = new LinePlus(-CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, 0f, CAMERA_HEIGHT * 2f - 12.5f, 25f, OLIVE);
        lines[9] = new LinePlus(-CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT, -CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT * 2f, 25f, OLIVE);
        // Bottom Left
        lines[10] = new LinePlus(-CAMERA_WIDTH + 12.5f, 0f, -CAMERA_WIDTH + 12.5f, -CAMERA_HEIGHT, 25f, PINK);
        lines[11] = new LinePlus(-CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, 0f, -CAMERA_HEIGHT + 12.5f, 25f, PINK);

        tests = new RectanglePlus[8];
        tests[0] = new RectanglePlus(1450f, -550f, 100f, 100f, CYAN);
        tests[1] = new RectanglePlus(-550, 450f, 100f, 100f, RED);
        tests[2] = new RectanglePlus(1450f, 450f, 100f, 100f, GREEN);
        tests[3] = new RectanglePlus(1450f, 1450f, 100f, 100f, YELLOW);
        tests[4] = new RectanglePlus(450f, -550f, 100f, 100f, ORANGE);
        tests[5] = new RectanglePlus(450f, 1450f, 100f, 100f, PURPLE);
        tests[6] = new RectanglePlus(-550f, 1450f, 100f, 100f, OLIVE);
        tests[7] = new RectanglePlus(-550f, -550f, 100f, 100f, PINK);

        player = new Player();
        base = new CirclePlus(500f - BASE_RADIUS, 500f - BASE_RADIUS, BASE_RADIUS, BLUE, CLEAR);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < lines.length; i++) {
            lines[i].draw(shapeDrawer);
        }
        for (int i = 0; i < tests.length; i++) {
            tests[i].draw(shapeDrawer);
        }
        player.draw(shapeDrawer);
        base.draw(shapeDrawer);
    }

    public LinePlus[] getLines() {
        return lines;
    }

    public RectanglePlus[] getTests() {
        return tests;
    }

    public Player getPlayer() {
        return player;
    }

    public CirclePlus getBase() {
        return base;
    }
}