package com.epicness.cuboids.game.logic.enemies;

import static com.epicness.cuboids.game.GameConstants.ENEMY_SPAWN_RATE;

import com.badlogic.gdx.utils.Array;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;
import com.epicness.fundamentals.utils.Random;

public class EnemySpawner extends GameLogicHandler {

    private EnemySpawn[] enemySpawns;
    private Array<Enemy> enemies;
    private float timer;

    @Override
    protected void init() {
        enemySpawns = stuff.getWorld2D().getEnemySpawners();
        enemies = stuff.getWorld2D().getEnemies();
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
        EnemySpawn randomSpawner = Random.fromArray(enemySpawns);
        Enemy enemy = new Enemy(randomSpawner.getEnemyVerts(), randomSpawner.enemyDirection);
        enemy.setPosition(randomSpawner.getPosition());
        enemies.add(enemy);
    }
}