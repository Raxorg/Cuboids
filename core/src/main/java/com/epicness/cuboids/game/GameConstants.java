package com.epicness.cuboids.game;

import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.DOWN_LEFT;
import static com.epicness.cuboids.game.constants.Direction.DOWN_RIGHT;
import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.RIGHT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.epicness.cuboids.game.constants.Direction;

public class GameConstants {

    public static final float CUBE_SIZE = 12f;

    public static final float PLAYER_SPEED = 500f;
    public static final float PLAYER_SIZE = 30f;
    public static final float PLAYER_RADIUS = PLAYER_SIZE / 2f;

    public static final float BASE_RADIUS = 50f;
    public static final float BASE_X = CAMERA_HALF_WIDTH - BASE_RADIUS;
    public static final float BASE_Y = CAMERA_HALF_HEIGHT - BASE_RADIUS;
    public static final float BASE_THICKNESS = 10f;

    public static final float[] BOTTOM_RIGHT_VERTS = {0f, 50f, 50f, 50f, 0f, 0f};
    public static final float[] BOTTOM_LEFT_VERTS = {50f, 50f, 50f, 0f, 0f, 50f};
    public static final float[] TOP_RIGHT_VERTS = {0f, 0f, 0f, 50f, 50f, 0f};
    public static final float[] TOP_LEFT_VERTS = {50f, 0f, 0f, 0f, 50f, 50f};
    public static final float[] BOTTOM_VERTS = {25f, 50f, 0f, 0f, 50f, 0f};
    public static final float[] TOP_VERTS = {25f, 0f, 0f, 50f, 50f, 50f};
    public static final float[] RIGHT_VERTS = {0f, 25f, 50f, 50f, 50f, 0f};
    public static final float[] LEFT_VERTS = {50f, 25f, 0f, 0f, 0f, 50f};

    public static final Direction[] WAVE_1_DATA = {DOWN, DOWN_LEFT, LEFT, UP_LEFT, UP, UP_RIGHT, RIGHT, DOWN_RIGHT};

    public static final Direction[] CYAN_COMBO = {UP, UP, DOWN};
}