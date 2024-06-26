package com.epicness.cuboids.game.logic.player;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.cuboids.game.GameConstants.NOTE_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.constants.Direction;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.SoundHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Base;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;

public class NoteHandler extends GameLogicHandler {

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
    public void keyDown(int keycode) {
        Enemy closestEnemy = findClosestEnemy();
        if (closestEnemy == null) return;

        Direction enemyDirection = closestEnemy.direction;
        if (directionMatchesKey(enemyDirection, keycode)) {
            get(SoundHandler.class).getSound(closestEnemy).play();
            enemies.begin();
            enemies.removeValue(closestEnemy, true);
            enemies.end();
        }
    }

    private Enemy findClosestEnemy() {
        Enemy current, closest = null;
        float closestDistance = Float.MAX_VALUE, distance;
        for (int i = 0; i < enemies.size; i++) {
            current = enemies.get(i);
            distance = base.getCenter(aux1).dst(current.getCenter(aux2));
            if (distance < closestDistance && distance <= NOTE_RADIUS) {
                closest = current;
                closestDistance = distance;
            }
        }
        return closest;
    }

    private boolean directionMatchesKey(Direction direction, int keycode) {
        switch (direction) {
            case UP:
                return keycode == S;
            case DOWN:
                return keycode == W;
            case LEFT:
                return keycode == D;
            case RIGHT:
                return keycode == A;
            case UP_RIGHT:
                return keycode == S || keycode == A;
            case UP_LEFT:
                return keycode == S || keycode == D;
            case DOWN_RIGHT:
                return keycode == W || keycode == A;
            case DOWN_LEFT:
            default:
                return keycode == W || keycode == D;

        }
    }
}