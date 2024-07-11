package com.epicness.cuboids.game.logic.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Base;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;

public class EnemySpawner extends GameLogicHandler {

    private SnapshotArray<Enemy> enemies;
    private Base base;
    private Vector2 aux1, aux2;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        base = stuff.getWorld2D().getBase();
        aux1 = new Vector2();
        aux2 = new Vector2();
    }

    public void spawnEnemy(EnemySpawn spawn, float speed) {
        Enemy enemy = new Enemy(spawn.enemyVerts, spawn.enemyDirection, speed, spawn.originalColor);
        enemy.setPosition(spawn.getCenter(aux1));
        enemy.distanceToCenter = enemy.getCenter(aux1).dst(base.getCenter(aux2));
        enemies.add(enemy);
    }
}