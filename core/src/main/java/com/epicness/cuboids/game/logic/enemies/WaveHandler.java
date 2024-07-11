package com.epicness.cuboids.game.logic.enemies;

import static com.badlogic.gdx.Input.Keys.F;
import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.DOWN_LEFT;
import static com.epicness.cuboids.game.constants.Direction.DOWN_RIGHT;
import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.RIGHT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;
import static com.epicness.cuboids.game.stuff.other.Wave.WAVES;

import com.epicness.cuboids.game.constants.Direction;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.InstructionsHandler;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;
import com.epicness.cuboids.game.stuff.other.Wave;

import java.util.HashMap;
import java.util.Map;

public class WaveHandler extends GameLogicHandler {

    private Map<Direction, EnemySpawn> spawnMap;
    private Wave currentWave;
    private int currentWaveIndex, currentDirectionIndex;
    private float time;
    private boolean spawning, gameStarted;

    @Override
    protected void init() {
        spawnMap = new HashMap<>();
        spawnMap.put(LEFT, stuff.getWorld2D().getSpawns().get(1));
        spawnMap.put(UP_LEFT, stuff.getWorld2D().getSpawns().get(6));
        spawnMap.put(UP, stuff.getWorld2D().getSpawns().get(5));
        spawnMap.put(UP_RIGHT, stuff.getWorld2D().getSpawns().get(3));
        spawnMap.put(RIGHT, stuff.getWorld2D().getSpawns().get(2));
        spawnMap.put(DOWN_RIGHT, stuff.getWorld2D().getSpawns().get(0));
        spawnMap.put(DOWN, stuff.getWorld2D().getSpawns().get(4));
        spawnMap.put(DOWN_LEFT, stuff.getWorld2D().getSpawns().get(7));

        spawning = false;
        gameStarted = false;
    }

    @Override
    protected void update(float delta) {
        if (!spawning) return;

        time += delta;
        if (time >= currentWave.spawnRate) {
            EnemySpawn spawn = spawnMap.get(currentWave.get(currentDirectionIndex));
            if (spawn != null) {
                get(EnemySpawner.class).spawnEnemy(spawn, currentWave.speed);
            } else {
                get(WaveTracker.class).enemyDisappears();
            }
            time -= currentWave.spawnRate;
            currentDirectionIndex++;
            if (currentDirectionIndex == currentWave.size) spawning = false;
        }
    }

    public void beginNextWave() {
        if (spawning) return;

        currentWaveIndex++;
        beginWave(WAVES[currentWaveIndex]);
    }

    private void beginWave(Wave wave) {
        currentWave = wave;
        currentDirectionIndex = 0;
        spawning = true;
        get(WaveTracker.class).trackWave(wave, currentWaveIndex);
        get(WaveTextHandler.class).setWave(currentWaveIndex + 1);
    }

    public void retryWave() {
        beginWave(currentWave);
    }

    @Override
    public void keyDown(int keycode) {
        if (gameStarted) return;

        if (keycode == F) {
            currentWaveIndex = -1;
            beginNextWave();
            gameStarted = true;
            get(InstructionsHandler.class).hideInstructions();
        }
    }
}