package com.epicness.cuboids.game.constants;

import com.badlogic.gdx.math.Vector2;

public enum Direction {

    UP(0f, 1f), DOWN(0f, -1f), LEFT(-1f, 0f), RIGHT(1f, 0f), UP_RIGHT(1f, 1f), UP_LEFT(-1f, 1f), DOWN_RIGHT(1f, -1f), DOWN_LEFT(-1f, -1f);

    public final Vector2 vector;

    Direction(float x, float y) {
        this.vector = new Vector2(x, y);
    }
}