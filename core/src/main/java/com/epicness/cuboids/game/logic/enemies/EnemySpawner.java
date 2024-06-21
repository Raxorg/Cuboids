package com.epicness.cuboids.game.logic.enemies;

import static com.epicness.cuboids.game.GameConstants.ENEMY_SPAWN_RATE;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;
import com.epicness.fundamentals.utils.Random;

public class EnemySpawner extends GameLogicHandler {

    private EnemySpawn[] enemySpawns;
    private SnapshotArray<Enemy> enemies;
    private Vector2 aux;
    private float timer;

    @Override
    protected void init() {
        enemySpawns = stuff.getWorld2D().getEnemySpawners();
        enemies = stuff.getWorld2D().getEnemies();
        aux = new Vector2();
    }

    @Override
    protected void update(float delta) {
        timer += delta;
        if (timer >= ENEMY_SPAWN_RATE) {
            spawnEnemy();
            timer -= ENEMY_SPAWN_RATE;
        }
    }

    private void spawnEnemy() {
        EnemySpawn randomSpawn = Random.fromArray(enemySpawns);
        Enemy enemy = new Enemy(randomSpawn.getEnemyVerts(), randomSpawn.enemyDirection, randomSpawn.originalColor);
        enemy.setPosition(randomSpawn.getCenter(aux));
        enemies.add(enemy);
    }
}