package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.cuboids.game.constants.GameConstants.SPAWN_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.cuboids.game.constants.Direction;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class EnemySpawn extends Fadeable implements Movable {

    private final Rectangle rectangle;
    public final float[] enemyVerts;
    public final Direction enemyDirection;

    public EnemySpawn(float x, float y, Color color, float[] enemyVerts, Direction enemyDirection) {
        rectangle = new Rectangle(x, y, SPAWN_SIZE, SPAWN_SIZE, 10f, color, CLEAR);
        this.enemyVerts = enemyVerts;
        this.enemyDirection = enemyDirection;
        originalColor.set(color);
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        rectangle.draw(shapeDrawer);
    }

    @Override
    public void setColor(Color color) {
        rectangle.setBorderColor(color);
    }

    @Override
    public float getX() {
        return rectangle.x;
    }

    @Override
    public void translateX(float amount) {
        rectangle.x += amount;
    }

    @Override
    public float getY() {
        return rectangle.y;
    }

    @Override
    public void translateY(float amount) {
        rectangle.y += amount;
    }

    public Vector2 getCenter(Vector2 result) {
        return result.set(getX() + rectangle.width / 2f, getY() + rectangle.height / 2f);
    }
}