package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class EnemySpawn extends Fadeable implements Movable {

    private final Rectangle rectangle;
    private final float[] enemyVerts;
    public final Vector2 enemyDirection;

    public EnemySpawn(float x, float y, float size, Color color, float[] enemyVerts, Vector2 enemyDirection) {
        rectangle = new Rectangle(x, y, size, size, color);
        this.enemyVerts = enemyVerts;
        this.enemyDirection = enemyDirection;
        originalColor.set(color);
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        rectangle.draw(shapeDrawer);
    }

    @Override
    public void setColor(Color color) {
        rectangle.setColor(color);
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

    public float[] getEnemyVerts() {
        return enemyVerts;
    }
}