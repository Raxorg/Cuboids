package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Triangle;

public class Enemy extends Fadeable implements Movable {

    private final Triangle triangle;
    public final Vector2 direction;

    public Enemy(float[] verts, Vector2 direction, Color color) {
        triangle = new Triangle(verts, color);
        this.direction = direction;
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
}