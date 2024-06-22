package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.interfaces.ShapeDrawable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Base extends Fadeable implements Movable, ShapeDrawable {

    private final Circle circle;

    public Base(float x, float y, float radius, Color borderColor, Color fillColor) {
        circle = new Circle(x, y, radius, borderColor, fillColor);
        originalColor.set(borderColor);
    }

    @Override
    public void draw(ShapeDrawerPlus shapeDrawer) {
        circle.draw(shapeDrawer);
    }

    @Override
    public float getX() {
        return circle.getX();
    }

    @Override
    public void translateX(float amount) {
        circle.translateX(amount);
    }

    @Override
    public float getY() {
        return circle.getY();
    }

    @Override
    public void translateY(float amount) {
        circle.translateY(amount);
    }

    @Override
    public void setColor(Color color) {
        circle.setBorderColor(color);
    }

    public Vector2 getCenter(Vector2 result) {
        return circle.getCenter(result);
    }
}