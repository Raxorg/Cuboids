package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.cuboids.game.constants.Direction;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Triangle;

public class Enemy extends Fadeable implements Movable {

    private final Triangle triangle;
    public final Direction direction;
    public final float speed;
    public float distanceToCenter;

    public Enemy(float[] verts, Direction direction, float speed, Color color) {
        triangle = new Triangle(verts, color);
        this.direction = direction;
        this.speed = speed;
        originalColor.set(color);
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        triangle.draw(shapeDrawer);
    }

    @Override
    public float getX() {
        return triangle.getX();
    }

    @Override
    public void translateX(float amount) {
        triangle.translateX(amount);
    }

    @Override
    public float getY() {
        return triangle.getY();
    }

    @Override
    public void translateY(float amount) {
        triangle.translateY(amount);
    }

    @Override
    public void setColor(Color color) {
        triangle.setColor(color);
    }

    public Vector2 getCenter(Vector2 result) {
        return triangle.getCenter(result);
    }
}