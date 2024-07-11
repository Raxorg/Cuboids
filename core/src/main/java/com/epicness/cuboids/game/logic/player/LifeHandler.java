package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.constants.GameConstants.INITIAL_LIVES;
import static com.epicness.cuboids.game.constants.GameConstants.LIFE_RADIUS;
import static com.epicness.cuboids.game.constants.GameConstants.LIFE_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.enemies.WaveHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class LifeHandler extends GameLogicHandler {

    private SnapshotArray<Circle> lives;
    private SnapshotArray<Enemy> enemies;

    @Override
    protected void init() {
        lives = stuff.getLives();
        enemies = stuff.getWorld2D().getEnemies();

        refillLives();
    }

    public void refillLives() {
        lives.clear();
        for (int i = 0; i < INITIAL_LIVES; i++) {
            lives.add(new Circle(10f + LIFE_SIZE * i + 10f * i, CAMERA_HEIGHT - LIFE_SIZE - 10f, LIFE_RADIUS));
        }
    }

    public void loseLife() {
        lives.removeIndex(lives.size - 1);

        if (lives.isEmpty()) {
            enemies.begin();
            enemies.clear();
            enemies.end();
            refillLives();
            get(WaveHandler.class).retryWave();
        }
    }
}