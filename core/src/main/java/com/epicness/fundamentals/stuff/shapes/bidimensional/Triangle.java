package com.epicness.fundamentals.stuff.shapes.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.interfaces.ShapeDrawable;

public class Triangle implements ShapeDrawable, Movable {

    private float x1, y1, x2, y2, x3, y3;
    private float thickness;
    private final Color color;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, float thickness, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.thickness = thickness;
        this.color = new Color(color);
    }

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this(x1, y1, x2, y2, x3, y3, 3f, new Color(1f, 1f, 1f, 1f));
    }

    public Triangle(float[] vertices, Color color) {
        this(vertices[0], vertices[1], vertices[2], vertices[3], vertices[4], vertices[5], 3f, color);
    }

    @Override
    public void draw(ShapeDrawerPlus shapeDrawer) {
        shapeDrawer.triangle(x1, y1, x2, y2, x3, y3, thickness, color.toFloatBits());
    }

    @Override
    public float getX() {
        return x1;
    }

    public float getEndX() {
        return Math.max(Math.max(x1, x2), x3);
    }

    @Override
    public void translateX(float amount) {
        x1 += amount;
        x2 += amount;
        x3 += amount;
    }

    @Override
    public float getY() {
        return y1;
    }

    public float getEndY() {
        return Math.max(Math.max(y1, y2), y3);
    }

    @Override
    public void translateY(float amount) {
        y1 += amount;
        y2 += amount;
        y3 += amount;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public Vector2 getCenter(Vector2 result) {
        float x = (x1 + x2 + x3) / 3f;
        float y = (y1 + y2 + y3) / 3f;
        return result.set(x, y);
    }
}