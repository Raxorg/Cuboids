package com.epicness.cuboids.game.stuff.other;

import static com.epicness.cuboids.game.constants.GameConstants.WAVE_10_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_1_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_2_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_3_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_4_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_5_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_6_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_7_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_8_DATA;
import static com.epicness.cuboids.game.constants.GameConstants.WAVE_9_DATA;

import com.epicness.cuboids.game.constants.Direction;

public class Wave {

    public static final Wave[] WAVES = new Wave[10];

    static {
        WAVES[0] = new Wave(WAVE_1_DATA, 60f / 80f, 320f);
        WAVES[1] = new Wave(WAVE_2_DATA, 60f / 100f, 340f);
        WAVES[2] = new Wave(WAVE_3_DATA, 60f / 120f, 360f);
        WAVES[3] = new Wave(WAVE_4_DATA, 60f / 140f, 380f);
        WAVES[4] = new Wave(WAVE_5_DATA, 60f / 270f, 400f);
        WAVES[5] = new Wave(WAVE_6_DATA, 60f / 250f, 420f);
        WAVES[6] = new Wave(WAVE_7_DATA, 60f / 200f, 440f);
        WAVES[7] = new Wave(WAVE_8_DATA, 60f / 270f, 460f);
        WAVES[8] = new Wave(WAVE_9_DATA, 60f / 360f, 480f);
        WAVES[9] = new Wave(WAVE_10_DATA, 60f / 260f, 500f);
    }

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