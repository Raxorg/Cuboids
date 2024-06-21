package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.CYAN;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.OLIVE;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PINK;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.cuboids.game.GameConstants.BASE_RADIUS;
import static com.epicness.cuboids.game.GameConstants.BOTTOM;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_LEFT;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_RIGHT;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_VERTS;
import static com.epicness.cuboids.game.GameConstants.LEFT;
import static com.epicness.cuboids.game.GameConstants.LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.RIGHT;
import static com.epicness.cuboids.game.GameConstants.RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP;
import static com.epicness.cuboids.game.GameConstants.TOP_LEFT;
import static com.epicness.cuboids.game.GameConstants.TOP_LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP_RIGHT;
import static com.epicness.cuboids.game.GameConstants.TOP_RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP_VERTS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;

public class World2D implements Drawable2D {

    private final EnemySpawn[] enemySpawns;
    private final Base base;
    private final SnapshotArray<Enemy> enemies;
    private final Player player;
    private final Border[] lines;

    public World2D() {
        enemySpawns = new EnemySpawn[8];
        initSpawners();

        base = new Base(500f - BASE_RADIUS, 500f - BASE_RADIUS, BASE_RADIUS, BLUE, CLEAR);
        enemies = new SnapshotArray<>();
        player = new Player();

        lines = new Border[12];
        initLines();
    }

    private void initLines() {
        // Top
        lines[0] = new Border(0f, CAMERA_HEIGHT * 2f - 12.5f, CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, 25f, PURPLE);
        // Right
        lines[1] = new Border(CAMERA_WIDTH * 2f - 12.5f, 0f, CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT, 25f, GREEN);
        // Top Right
        lines[2] = new Border(CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, CAMERA_WIDTH * 2f, CAMERA_HEIGHT * 2f - 12.5f, 25f, YELLOW);
        lines[3] = new Border(CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12.5f, CAMERA_HEIGHT * 2f, 25f, YELLOW);
        // Bottom
        lines[4] = new Border(0f, -CAMERA_HEIGHT + 12.5f, CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, 25f, ORANGE);
        // Bottom Right
        lines[5] = new Border(CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, CAMERA_WIDTH * 2f, -CAMERA_HEIGHT + 12.5f, 25f, CYAN);
        lines[6] = new Border(CAMERA_WIDTH * 2f - 12.5f, -CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12.5f, 0f - 12.5f, 25f, CYAN);
        // Left
        lines[7] = new Border(-CAMERA_WIDTH + 12.5f, 0f, -CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT, 25f, RED);
        // Top Left
        lines[8] = new Border(-CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12.5f, 0f, CAMERA_HEIGHT * 2f - 12.5f, 25f, OLIVE);
        lines[9] = new Border(-CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT, -CAMERA_WIDTH + 12.5f, CAMERA_HEIGHT * 2f, 25f, OLIVE);
        // Bottom Left
        lines[10] = new Border(-CAMERA_WIDTH + 12.5f, 0f, -CAMERA_WIDTH + 12.5f, -CAMERA_HEIGHT, 25f, PINK);
        lines[11] = new Border(-CAMERA_WIDTH, -CAMERA_HEIGHT + 12.5f, 0f, -CAMERA_HEIGHT + 12.5f, 25f, PINK);
    }

    private void initSpawners() {
        enemySpawns[0] = new EnemySpawn(1450f, -550f, 100f, CYAN, TOP_LEFT_VERTS, TOP_LEFT);
        enemySpawns[1] = new EnemySpawn(-550, 450f, 100f, RED, RIGHT_VERTS, RIGHT);
        enemySpawns[2] = new EnemySpawn(1450f, 450f, 100f, GREEN, LEFT_VERTS, LEFT);
        enemySpawns[3] = new EnemySpawn(1450f, 1450f, 100f, YELLOW, BOTTOM_LEFT_VERTS, BOTTOM_LEFT);
        enemySpawns[4] = new EnemySpawn(450f, -550f, 100f, ORANGE, TOP_VERTS, TOP);
        enemySpawns[5] = new EnemySpawn(450f, 1450f, 100f, PURPLE, BOTTOM_VERTS, BOTTOM);
        enemySpawns[6] = new EnemySpawn(-550f, 1450f, 100f, OLIVE, BOTTOM_RIGHT_VERTS, BOTTOM_RIGHT);
        enemySpawns[7] = new EnemySpawn(-550f, -550f, 100f, PINK, TOP_RIGHT_VERTS, TOP_RIGHT);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < enemySpawns.length; i++) {
            enemySpawns[i].draw(shapeDrawer);
        }
        base.draw(shapeDrawer);
        for (int i = 0; i < enemies.size; i++) {
            enemies.get(i).draw(shapeDrawer);
        }
        player.draw(shapeDrawer);
        for (int i = 0; i < lines.length; i++) {
            lines[i].draw(shapeDrawer);
        }
    }

    public EnemySpawn[] getEnemySpawners() {
        return enemySpawns;
    }

    public Base getBase() {
        return base;
    }

    public SnapshotArray<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public Border[] getLines() {
        return lines;
    }
}