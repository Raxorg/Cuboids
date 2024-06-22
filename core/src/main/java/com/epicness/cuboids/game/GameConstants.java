package com.epicness.cuboids.game;

import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.UP;

import com.epicness.cuboids.game.constants.Direction;

public class GameConstants {

    public static final float CUBE_SIZE = 12f;

    public static final float PLAYER_SPEED = 500f;
    public static final float PLAYER_SIZE = 30f;
    public static final float PLAYER_RADIUS = PLAYER_SIZE / 2f;

    public static final float BASE_RADIUS = 40f;

    public static final float[] BOTTOM_RIGHT_VERTS = {0f, 50f, 50f, 50f, 0f, 0f};
    public static final float[] BOTTOM_LEFT_VERTS = {50f, 50f, 50f, 0f, 0f, 50f};
    public static final float[] TOP_RIGHT_VERTS = {0f, 0f, 0f, 50f, 50f, 0f};
    public static final float[] TOP_LEFT_VERTS = {50f, 0f, 0f, 0f, 50f, 50f};
    public static final float[] BOTTOM_VERTS = {25f, 50f, 0f, 0f, 50f, 0f};
    public static final float[] TOP_VERTS = {25f, 0f, 0f, 50f, 50f, 50f};
    public static final float[] RIGHT_VERTS = {0f, 25f, 50f, 50f, 50f, 0f};
    public static final float[] LEFT_VERTS = {50f, 25f, 0f, 0f, 0f, 50f};

    public static final Direction[] CYAN_COMBO = {UP, UP, DOWN};
}