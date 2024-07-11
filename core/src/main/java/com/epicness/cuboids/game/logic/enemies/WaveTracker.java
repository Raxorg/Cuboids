package com.epicness.cuboids.game.logic.enemies;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.player.LifeHandler;
import com.epicness.cuboids.game.logic.player.PlayerEnabler;
import com.epicness.cuboids.game.logic.spawns.SpawnChooser;
import com.epicness.cuboids.game.stuff.other.Wave;

public class WaveTracker extends GameLogicHandler {

    private int remainingEnemies;
    private int index;

    @Override
    protected void init() {
    }

    public void trackWave(Wave wave, int index) {
        remainingEnemies = wave.size;
        this.index = index;
    }

    public void enemyDisappears() {
        remainingEnemies--;
        if (remainingEnemies == 0) {
            get(SpawnChooser.class).resetSpawnColors();
            get(PlayerEnabler.class).enablePlayer();
            get(LifeHandler.class).refillLives();
            if (index == 9) {
                get(PlayerEnabler.class).disablePlayer();
                stuff.getFreeMovementText().setText("YOU WIN!\nTHANKS FOR PLAYING!");
            }
        }
    }
}