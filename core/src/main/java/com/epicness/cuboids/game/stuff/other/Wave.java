package com.epicness.cuboids.game.stuff.other;

import static com.epicness.cuboids.game.GameConstants.WAVE_1_DATA;

import com.epicness.cuboids.game.constants.Direction;

public class Wave {

    public static final Wave WAVE_1 = new Wave(WAVE_1_DATA, 1f, 150f);

    private final Direction[] directions;
    public final int size;
    public final float spawnRate;
    public final float speed;

    private Wave(Direction[] directions, float spawnRate, float speed) {
        this.directions = directions;
        size = directions.length;
        this.spawnRate = spawnRate;
        this.speed = speed;
    }

    public Direction get(int index) {
        return directions[index];
    }
}