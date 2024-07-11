package com.epicness.cuboids.game.stuff.bidimensional;

import static com.epicness.cuboids.game.constants.GameConstants.PLAYER_RADIUS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Player extends Fadeable implements Movable {

    private final Circle circle;
    public final Vector2 speed;

    public Player() {
        circle = new Circle(CAMERA_HALF_WIDTH - PLAYER_RADIUS, CAMERA_HALF_HEIGHT - PLAYER_RADIUS, PLAYER_RADIUS);
        speed = new Vector2();
    }

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
        circle.setColor(color);
    }

    public Vector2 getCenter(Vector2 result) {
        return circle.getCenter(result);
    }
}