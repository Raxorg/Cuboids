package com.epicness.cuboids.game.constants;

import com.badlogic.gdx.math.Vector2;

public enum Direction {

    UP(0f, 1f), DOWN(0f, -1f), LEFT(-1f, 0f), RIGHT(1f, 0f),
    UP_RIGHT(1.02f, 1.02f), UP_LEFT(-1.02f, 1.02f), DOWN_RIGHT(1.02f, -1.02f), DOWN_LEFT(-1.02f, -1.02f);

    public static final Direction DO = DOWN, RE = DOWN_LEFT, MI = LEFT, FA = UP_LEFT, SOL = UP, LA = UP_RIGHT, SI = RIGHT, DO2 = DOWN_RIGHT;
    public final Vector2 vector;

    Direction(float x, float y) {
        this.vector = new Vector2(x, y);
    }
}