package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Player {

    private final Circle circle;
    public final Vector2 speed;

    public Player() {
        circle = new Circle(50f);
        speed = new Vector2();
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        circle.draw(shapeDrawer);
    }

    public void translate(Vector2 amount) {
        circle.translate(amount);
    }
}