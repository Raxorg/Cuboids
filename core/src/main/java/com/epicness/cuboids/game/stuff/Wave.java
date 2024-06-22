package com.epicness.cuboids.game.stuff;

import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;

import com.epicness.cuboids.game.constants.Direction;

public class Wave {

    public static final Wave WAVE_1 = new Wave(new Direction[]{UP, UP_RIGHT, LEFT}, 2f);

    private final Direction[] directions;
    public final int size;
    public final float spawnRate;

    private Wave(Direction[] directions, float spawnRate) {
        this.directions = directions;
        size = directions.length;
        this.spawnRate = spawnRate;
    }

    public Direction get(int index) {
        return directions[index];
    }
}