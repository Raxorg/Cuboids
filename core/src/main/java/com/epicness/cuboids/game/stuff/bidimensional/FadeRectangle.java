package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class FadeRectangle extends Fadeable implements Movable {

    private final Rectangle rectangle;

    public FadeRectangle(float x, float y, float w, float h, Color color) {
        rectangle = new Rectangle(x, y, w, h, CLEAR, color);
        originalColor.set(color);
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        rectangle.draw(shapeDrawer);
    }

    @Override
    public float getX() {
        return rectangle.getX();
    }

    @Override
    public void translateX(float amount) {
        rectangle.x += amount;
    }

    @Override
    public float getY() {
        return rectangle.getY();
    }

    @Override
    public void translateY(float amount) {
        rectangle.y += amount;
    }

    @Override
    public void setColor(Color color) {
        rectangle.setFillColor(color);
    }
}
