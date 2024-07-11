package com.epicness.cuboids.game.logic.enemies;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.epicness.cuboids.game.constants.GameConstants.NOTE_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.OverlayHandler;
import com.epicness.cuboids.game.logic.player.LifeHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Base;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;

public class EnemyMover extends GameLogicHandler {

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

    @Override
    protected void update(float delta) {
        Enemy enemy;
        enemies.begin();
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
            move(enemy, delta);
            checkDistance(enemy);
        }
        enemies.end();
    }

    private void move(Enemy enemy, float delta) {
        aux1.set(enemy.direction.vector).scl(enemy.speed * delta);
        enemy.translate(aux1);
    }

    private void checkDistance(Enemy enemy) {
        float distanceToCenter = enemy.distanceToCenter;
        enemy.distanceToCenter = enemy.getCenter(aux1).dst(base.getCenter(aux2));
        if (distanceToCenter < enemy.distanceToCenter && enemy.distanceToCenter > NOTE_RADIUS) {
            enemies.removeValue(enemy, true);
            get(LifeHandler.class).loseLife();
            get(OverlayHandler.class).appear(RED);
        }
    }
}