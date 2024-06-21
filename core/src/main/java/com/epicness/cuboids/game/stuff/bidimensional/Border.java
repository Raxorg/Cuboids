package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.interfaces.ShapeDrawable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;

public class Border extends Fadeable implements Movable, ShapeDrawable {

    private final Line line;

    public Border(float ax, float ay, float bx, float by, float thickness, Color color) {
        line = new Line(ax, ay, bx, by, thickness, color);
        originalColor.set(color);
    }

    @Override
    public void draw(ShapeDrawerPlus shapeDrawer) {
        line.draw(shapeDrawer);
    }

    @Override
    public void setColor(Color color) {
        line.setColor(color);
    }

    @Override
    public float getX() {
        return line.getX();
    }

    @Override
    public void translateX(float amount) {
        line.translateX(amount);
    }

    @Override
    public float getY() {
        return line.getY();
    }

    @Override
    public void translateY(float amount) {
        line.translateY(amount);
    }
}