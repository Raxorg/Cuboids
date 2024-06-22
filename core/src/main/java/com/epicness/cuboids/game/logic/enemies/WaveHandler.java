package com.epicness.cuboids.game.logic.enemies;

import static com.badlogic.gdx.Input.Keys.O;
import static com.epicness.cuboids.game.constants.Direction.DOWN;
import static com.epicness.cuboids.game.constants.Direction.DOWN_LEFT;
import static com.epicness.cuboids.game.constants.Direction.DOWN_RIGHT;
import static com.epicness.cuboids.game.constants.Direction.LEFT;
import static com.epicness.cuboids.game.constants.Direction.RIGHT;
import static com.epicness.cuboids.game.constants.Direction.UP;
import static com.epicness.cuboids.game.constants.Direction.UP_LEFT;
import static com.epicness.cuboids.game.constants.Direction.UP_RIGHT;
import static com.epicness.cuboids.game.stuff.Wave.WAVE_1;

import com.epicness.cuboids.game.constants.Direction;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.Wave;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;

import java.util.HashMap;
import java.util.Map;

public class WaveHandler extends GameLogicHandler {

    private Map<Direction, EnemySpawn> spawnMap;
    private Wave currentWave;
    private int currentIndex;
    private float time;
    private boolean spawning;

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
    }

    @Override
    protected void update(float delta) {
        if (!spawning) return;

        time += delta;
        if (time >= currentWave.spawnRate) {
            get(EnemySpawner.class).spawnEnemy(spawnMap.get(currentWave.get(currentIndex)));
            time -= currentWave.spawnRate;
            currentIndex++;
            if (currentIndex == currentWave.size) spawning = false;
        }
    }

    public void beginWave(Wave wave) {
        currentWave = wave;
        currentIndex = 0;
        spawning = true;
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == O) {
            beginWave(WAVE_1);
        }
    }
}