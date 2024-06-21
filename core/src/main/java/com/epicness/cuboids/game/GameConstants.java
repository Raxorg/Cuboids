package com.epicness.cuboids.game;

import com.badlogic.gdx.math.Vector2;

public class GameConstants {

    public static final float CUBE_SIZE = 12f;

    public static final float PLAYER_SPEED = 500f;
    public static final float PLAYER_SIZE = 30f;
    public static final float PLAYER_RADIUS = PLAYER_SIZE / 2f;

    public static final float BASE_RADIUS = 40f;

    public static final float ENEMY_SPAWN_RATE = 0.5f;

    public static final float[] TOP_LEFT_VERTS = {0f, 0f, 0f, 50f, 50f, 50f};
    public static final float[] TOP_RIGHT_VERTS = {0f, 50f, 50f, 50f, 50f, 0f};
    public static final float[] BOTTOM_LEFT_VERTS = {0f, 0f, 0f, 50f, 50f, 0f};
    public static final float[] BOTTOM_RIGHT_VERTS = {0f, 0f, 50f, 50f, 50f, 0f};
    public static final float[] TOP_VERTS = {0f, 0f, 25f, 50f, 50f, 0f};
    public static final float[] BOTTOM_VERTS = {0f, 50f, 50f, 50f, 25f, 0f};
    public static final float[] LEFT_VERTS = {50f, 0f, 0f, 25f, 50f, 50f};
    public static final float[] RIGHT_VERTS = {0f, 0f, 0f, 50f, 50f, 25f};

    public static final Vector2 TOP_LEFT = new Vector2(-1f, 1f).nor();
    public static final Vector2 TOP_RIGHT = new Vector2(1f, 1f).nor();
    public static final Vector2 BOTTOM_LEFT = new Vector2(-1f, -1f).nor();
    public static final Vector2 BOTTOM_RIGHT = new Vector2(1f, -1f).nor();
    public static final Vector2 TOP = new Vector2(0f, 1f);
    public static final Vector2 BOTTOM = new Vector2(0f, -1f);
    public static final Vector2 LEFT = new Vector2(-1f, 0f);
    public static final Vector2 RIGHT = new Vector2(1f, 0f);
}