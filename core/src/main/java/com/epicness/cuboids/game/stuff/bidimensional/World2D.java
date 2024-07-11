package com.epicness.cuboids.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.CYAN;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.OLIVE;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PINK;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.cuboids.game.constants.GameConstants.BOTTOM_LEFT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.BOTTOM_RIGHT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.BOTTOM_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.LEFT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.RIGHT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.SPAWN_SIZE;
import static com.epicness.cuboids.game.constants.GameConstants.TOP_LEFT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.TOP_RIGHT_VERTS;
import static com.epicness.cuboids.game.constants.GameConstants.TOP_VERTS;
import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.DOWN_LEFT;
import static com.epicness.cuboids.game.constants.Direction.DOWN_RIGHT;
import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.RIGHT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;
import static com.epicness.fundamentals.constants.ColorConstants.WHITE_50;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.utils.TextUtils.copyOf;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class World2D implements Drawable2D {

    private final SnapshotArray<EnemySpawn> spawns;
    private final Base base;
    private final SnapshotArray<Enemy> enemies;
    private final Player player;
    private final Border[] lines;
    private final FadeRectangle[] rectangles;
    private final Rectangle overlay;
    private final Text cakeText;

    public World2D(SharedAssets sharedAssets) {
        spawns = new SnapshotArray<>();
        initSpawners();

        base = new Base();
        enemies = new SnapshotArray<>();
        player = new Player();

        lines = new Border[12];
        initLines();

        rectangles = new FadeRectangle[4];
        initRectangles();

        overlay = new Rectangle(-CAMERA_WIDTH, -CAMERA_HEIGHT, CAMERA_WIDTH * 3f, CAMERA_HEIGHT * 3f);

        cakeText = new Text(copyOf(sharedAssets.getTimesSquare()));
        cakeText.setX(CAMERA_WIDTH * 2f);
        cakeText.setY(CAMERA_HALF_HEIGHT);
        cakeText.setWidth(CAMERA_WIDTH);
        cakeText.setVerticallyCentered(true);
        cakeText.hAlignCenter();
        cakeText.setText("C");
        cakeText.setScale(3f);
        cakeText.setColor(WHITE_50);
    }

    private void initSpawners() {
        spawns.add(new EnemySpawn(1450f, -550f, CYAN, TOP_LEFT_VERTS, UP_LEFT));
        spawns.add(new EnemySpawn(-550, 450f, RED, RIGHT_VERTS, RIGHT));
        spawns.add(new EnemySpawn(1450f, 450f, GREEN, LEFT_VERTS, LEFT));
        spawns.add(new EnemySpawn(1450f, 1450f, YELLOW, BOTTOM_LEFT_VERTS, DOWN_LEFT));
        spawns.add(new EnemySpawn(450f, -550f, ORANGE, TOP_VERTS, UP));
        spawns.add(new EnemySpawn(450f, 1450f, PURPLE, BOTTOM_VERTS, DOWN));
        spawns.add(new EnemySpawn(-550f, 1450f, OLIVE, BOTTOM_RIGHT_VERTS, DOWN_RIGHT));
        spawns.add(new EnemySpawn(-550f, -550f, PINK, TOP_RIGHT_VERTS, UP_RIGHT));
    }

    private void initLines() {
        // Top
        lines[0] = new Border(0f, CAMERA_HEIGHT * 2f - 12f, CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12f, 24f, PURPLE);
        // Right
        lines[1] = new Border(CAMERA_WIDTH * 2f - 12f, 0f, CAMERA_WIDTH * 2f - 12f, CAMERA_HEIGHT, 24f, GREEN);
        // Top Right
        lines[2] = new Border(CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12f, CAMERA_WIDTH * 2f, CAMERA_HEIGHT * 2f - 12f, 24f, YELLOW);
        lines[3] = new Border(CAMERA_WIDTH * 2f - 12f, CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12f, CAMERA_HEIGHT * 2f, 24f, YELLOW);
        // Bottom
        lines[4] = new Border(0f, -CAMERA_HEIGHT + 12f, CAMERA_WIDTH, -CAMERA_HEIGHT + 12f, 24f, ORANGE);
        // Bottom Right
        lines[5] = new Border(CAMERA_WIDTH, -CAMERA_HEIGHT + 12f, CAMERA_WIDTH * 2f, -CAMERA_HEIGHT + 12f, 24f, CYAN);
        lines[6] = new Border(CAMERA_WIDTH * 2f - 12f, -CAMERA_HEIGHT, CAMERA_WIDTH * 2f - 12f, 0f - 12f, 24f, CYAN);
        // Left
        lines[7] = new Border(-CAMERA_WIDTH + 12f, 0f, -CAMERA_WIDTH + 12f, CAMERA_HEIGHT, 24f, RED);
        // Top Left
        lines[8] = new Border(-CAMERA_WIDTH, CAMERA_HEIGHT * 2f - 12f, 0f, CAMERA_HEIGHT * 2f - 12f, 24f, OLIVE);
        lines[9] = new Border(-CAMERA_WIDTH + 12f, CAMERA_HEIGHT, -CAMERA_WIDTH + 12f, CAMERA_HEIGHT * 2f, 24f, OLIVE);
        // Bottom Left
        lines[10] = new Border(-CAMERA_WIDTH + 12f, 0f, -CAMERA_WIDTH + 12f, -CAMERA_HEIGHT, 24f, PINK);
        lines[11] = new Border(-CAMERA_WIDTH, -CAMERA_HEIGHT + 12f, 0f, -CAMERA_HEIGHT + 12f, 24f, PINK);
    }

    private void initRectangles() {
        rectangles[0] = new FadeRectangle(CAMERA_WIDTH, CAMERA_HEIGHT * 0.45f, CAMERA_WIDTH, SPAWN_SIZE, GREEN.cpy().lerp(CLEAR, 0.5f));
        rectangles[1] = new FadeRectangle(-CAMERA_WIDTH, CAMERA_HEIGHT * 0.45f, CAMERA_WIDTH, SPAWN_SIZE, RED.cpy().lerp(CLEAR, 0.5f));
        rectangles[2] = new FadeRectangle(CAMERA_HALF_WIDTH - 50f, CAMERA_HEIGHT, SPAWN_SIZE, CAMERA_HEIGHT, PURPLE.cpy().lerp(CLEAR, 0.5f));
        rectangles[3] = new FadeRectangle(CAMERA_HALF_WIDTH - 50f, -CAMERA_HEIGHT, SPAWN_SIZE, CAMERA_HEIGHT, ORANGE.cpy().lerp(CLEAR, 0.5f));
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
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].draw(shapeDrawer);
        }
        overlay.draw(shapeDrawer);
        cakeText.draw(spriteBatch);
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

    public FadeRectangle[] getRectangles() {
        return rectangles;
    }

    public Rectangle getOverlay() {
        return overlay;
    }

    public Text getCakeText() {
        return cakeText;
    }
}