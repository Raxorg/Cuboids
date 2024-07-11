package com.epicness.cuboids.game.logic.base;

import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.cuboids.game.constants.GameConstants.BASE_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.enemies.WaveHandler;
import com.epicness.cuboids.game.logic.player.PlayerEnabler;
import com.epicness.cuboids.game.stuff.bidimensional.Base;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class BaseHandler extends GameLogicHandler {

    private Base base;
    private Player player;
    private SnapshotArray<EnemySpawn> enemySpawns;
    private Vector2 baseCenter, playerCenter;

    @Override
    protected void init() {
        base = stuff.getWorld2D().getBase();
        player = stuff.getWorld2D().getPlayer();
        enemySpawns = stuff.getWorld2D().getSpawns();
        baseCenter = new Vector2();
        playerCenter = new Vector2();
    }

    public void checkProximity() {
        for (int i = 0; i < enemySpawns.size; i++) {
            if (enemySpawns.get(i).originalColor.equals(WHITE)) {
                break;
            }
            if (i == enemySpawns.size - 1) return;
        }

        base.getCenter(baseCenter);
        player.getCenter(playerCenter);
        if (baseCenter.dst(playerCenter) <= BASE_RADIUS) {
            get(PlayerEnabler.class).disablePlayer();
            get(WaveHandler.class).beginNextWave();
        }
    }
}