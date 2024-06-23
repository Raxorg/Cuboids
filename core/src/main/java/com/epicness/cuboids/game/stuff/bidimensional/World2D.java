package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CYAN;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.OLIVE;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PINK;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.BOTTOM_VERTS;
import static com.epicness.cuboids.game.GameConstants.CYAN_COMBO;
import static com.epicness.cuboids.game.GameConstants.LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP_LEFT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP_RIGHT_VERTS;
import static com.epicness.cuboids.game.GameConstants.TOP_VERTS;
import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.DOWN_LEFT;
import static com.epicness.cuboids.game.constants.Direction.DOWN_RIGHT;
import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.RIGHT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class World2D implements Drawable2D {

    private final SnapshotArray<EnemySpawn> spawns;
    private final Base base;
    private final SnapshotArray<Enemy> enemies;
    private final Player player;
    private final Border[] lines;
    private final Rectangle overlay;

    public World2D() {

        spawns = new SnapshotArray<>();
        initSpawners();

        base = new Base();
        enemies = new SnapshotArray<>();
        player = new Player();

        lines = new Border[12];
        initLines();

        overlay = new Rectangle(-CAMERA_WIDTH, -CAMERA_HEIGHT, CAMERA_WIDTH * 3f, CAMERA_HEIGHT * 3f);
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
        spawns.add(new EnemySpawn(1450f, -550f, 100f, CYAN, TOP_LEFT_VERTS, UP_LEFT, CYAN_COMBO));
        spawns.add(new EnemySpawn(-550, 450f, 100f, RED, RIGHT_VERTS, RIGHT, CYAN_COMBO));
        spawns.add(new EnemySpawn(1450f, 450f, 100f, GREEN, LEFT_VERTS, LEFT, CYAN_COMBO));
        spawns.add(new EnemySpawn(1450f, 1450f, 100f, YELLOW, BOTTOM_LEFT_VERTS, DOWN_LEFT, CYAN_COMBO));
        spawns.add(new EnemySpawn(450f, -550f, 100f, ORANGE, TOP_VERTS, UP, CYAN_COMBO));
        spawns.add(new EnemySpawn(450f, 1450f, 100f, PURPLE, BOTTOM_VERTS, DOWN, CYAN_COMBO));
        spawns.add(new EnemySpawn(-550f, 1450f, 100f, OLIVE, BOTTOM_RIGHT_VERTS, DOWN_RIGHT, CYAN_COMBO));
        spawns.add(new EnemySpawn(-550f, -550f, 100f, PINK, TOP_RIGHT_VERTS, UP_RIGHT, CYAN_COMBO));
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < spawns.size; i++) {
            spawns.get(i).draw(shapeDrawer);
        }
        base.draw(shapeDrawer);
        for (int i = 0; i < enemies.size; i++) {
            enemies.get(i).draw(shapeDrawer);
        }
        player.draw(shapeDrawer);
        for (int i = 0; i < lines.length; i++) {
            lines[i].draw(shapeDrawer);
        }
        overlay.draw(shapeDrawer);
    }

    public SnapshotArray<EnemySpawn> getSpawns() {
        return spawns;
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

    public Rectangle getOverlay() {
        return overlay;
    }
}