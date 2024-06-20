package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class RectanglePlus extends Fadeable implements Movable {

    private final Rectangle rectangle;

    public RectanglePlus(float x, float y, float w, float h, Color color) {
        rectangle = new Rectangle(x, y, w, h, color);
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
}