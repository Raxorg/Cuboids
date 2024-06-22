package com.epicness.cuboids.game.logic.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;

public class EnemyMover extends GameLogicHandler {

    private SnapshotArray<Enemy> enemies;
    private Vector2 aux;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        aux = new Vector2();
    }

    @Override
    protected void update(float delta) {
        Enemy enemy;
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
            aux.set(enemy.direction.vector).scl(100f * delta);
            enemy.translate(aux);
        }
    }
}