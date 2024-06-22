package com.epicness.cuboids.game.logic.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.SoundHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;

public class EnemySpawner extends GameLogicHandler {

    private SnapshotArray<Enemy> enemies;
    private Vector2 aux;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        aux = new Vector2();
    }

    public void spawnEnemy(EnemySpawn spawn, float speed) {
        Enemy enemy = new Enemy(spawn.enemyVerts, spawn.enemyDirection, speed, spawn.originalColor);
        enemy.setPosition(spawn.getCenter(aux));
        enemies.add(enemy);
        get(SoundHandler.class).getSound(enemy).play();
    }
}