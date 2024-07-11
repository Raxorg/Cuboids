package com.epicness.cuboids.game.constants;

import static com.epicness.cuboids.game.constants.Direction.DO;
import static com.epicness.cuboids.game.constants.Direction.DO2;
import static com.epicness.cuboids.game.constants.Direction.FA;
import static com.epicness.cuboids.game.constants.Direction.LA;
import static com.epicness.cuboids.game.constants.Direction.MI;
import static com.epicness.cuboids.game.constants.Direction.RE;
import static com.epicness.cuboids.game.constants.Direction.SI;
import static com.epicness.cuboids.game.constants.Direction.SOL;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

public class GameConstants {

    public static final float CUBE_SIZE = 12f;

    public static final float PLAYER_SPEED = 600f;
    public static final float PLAYER_SIZE = 30f;
    public static final float PLAYER_RADIUS = PLAYER_SIZE / 2f;

    public static final float SPAWN_SIZE = 100f;

    public static final float BASE_RADIUS = 50f;
    public static final float BASE_X = CAMERA_HALF_WIDTH - BASE_RADIUS;
    public static final float BASE_Y = CAMERA_HALF_HEIGHT - BASE_RADIUS;
    public static final float BASE_THICKNESS = 10f;

    public static final float NOTE_RADIUS = BASE_RADIUS * 1.2f;

    public static final int INITIAL_LIVES = 3;
    public static final float LIFE_SIZE = 30f;
    public static final float LIFE_RADIUS = LIFE_SIZE / 2f;

    public static final float[] BOTTOM_RIGHT_VERTS = {0f, 50f, 50f, 50f, 0f, 0f};
    public static final float[] BOTTOM_LEFT_VERTS = {50f, 50f, 50f, 0f, 0f, 50f};
    public static final float[] TOP_RIGHT_VERTS = {0f, 0f, 0f, 50f, 50f, 0f};
    public static final float[] TOP_LEFT_VERTS = {50f, 0f, 0f, 0f, 50f, 50f};
    public static final float[] BOTTOM_VERTS = {25f, 50f, 0f, 0f, 50f, 0f};
    public static final float[] TOP_VERTS = {25f, 0f, 0f, 50f, 50f, 50f};
    public static final float[] RIGHT_VERTS = {0f, 25f, 50f, 50f, 50f, 0f};
    public static final float[] LEFT_VERTS = {50f, 25f, 0f, 0f, 0f, 50f};

    public static final Direction[] WAVE_1_DATA = {DO, RE, MI, FA, SOL, LA, SI, DO2};
    public static final Direction[] WAVE_2_DATA = {DO, DO, SOL, SOL, LA, LA, SOL, null, FA, FA, MI, MI, RE, RE, DO};
    public static final Direction[] WAVE_3_DATA = {DO, RE, MI, DO, DO, RE, MI, DO, MI, FA, SOL, null, MI, FA, SOL};
    public static final Direction[] WAVE_4_DATA = {MI, RE, DO, RE, MI, MI, MI, null, RE, RE, RE, null, MI, SOL, SOL};
    public static final Direction[] WAVE_5_DATA = {MI, null, MI, null, FA, null, SOL, null, SOL, null, FA, null, MI,
        null, RE, null, DO, null, DO, null, RE, null, MI, null, MI, null, RE, RE, null, null, MI, null, MI, null, FA,
        null, SOL, null, SOL, null, FA, null, MI, null, RE, null, DO, null, DO, null, RE, null, MI, null, RE, null,
        null, DO, DO};
    public static final Direction[] WAVE_6_DATA = {DO, null, DO, null, DO, null, RE, MI, null, MI, null, RE, MI,
        null, FA, SOL, null, null, null, DO2, null, DO2, null, SOL, null, SOL, null, MI, null, RE, null, DO, null,
        SOL, null, FA, MI, null, RE, DO};
    public static final Direction[] WAVE_7_DATA = {MI, MI, MI, null, MI, MI, MI, null, MI, SOL, DO, RE, MI, null,
        null, FA, FA, FA, FA, FA, MI, MI, null, MI, RE, RE, MI, RE, null, SOL};
    public static final Direction[] WAVE_8_DATA = {SOL, null, LA, SOL, null, FA, null, MI, null, FA, null, SOL, null,
        null, RE, null, MI, null, FA, null, null, MI, null, FA, null, SOL, null, null, null, SOL, null, LA, SOL,
        null, FA, null, MI, null, FA, null, SOL, null, null, RE, null, null, SOL, null, null, MI, DO};
    // Ode to Joy - Beethoven
    public static final Direction[] WAVE_9_DATA = {MI, null, MI, null, FA, null, SOL, null, SOL, null, FA, null, MI,
        null, RE, null, DO, null, DO, null, RE, null, MI, null, MI, null, null, RE, RE, null, null, MI, null, MI, null,
        FA, null, SOL, null, SOL, null, FA, null, MI, null, RE, null, DO, null, DO, null, RE, null, MI, null, RE, null,
        null, DO, DO};
    // Star Wars
    public static final Direction[] WAVE_10_DATA = {DO, null, null, SOL, null, null, FA, null, MI, null, RE, null, DO2, null, SOL,
        SOL, null, FA, null, MI, null, RE, null, DO2, null, SOL, SOL, null, FA, null, MI, null, FA, null, RE
    };
}