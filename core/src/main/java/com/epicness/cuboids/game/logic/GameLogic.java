package com.epicness.cuboids.game.logic;

import com.epicness.cuboids.game.logic.enemies.EnemyMover;
import com.epicness.cuboids.game.logic.enemies.EnemySpawner;
import com.epicness.cuboids.game.logic.other.CameraHandler;
import com.epicness.cuboids.game.logic.other.Fader;
import com.epicness.cuboids.game.logic.other.Rotator;
import com.epicness.cuboids.game.logic.other.StuffMover;
import com.epicness.cuboids.game.logic.player.BoundsHandler;
import com.epicness.cuboids.game.logic.player.PlayerMover;
import com.epicness.cuboids.game.logic.player.PlayerTracker;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Enemies
    private final EnemyMover enemyMover;
    private final EnemySpawner enemySpawner;
    // Other
    private final CameraHandler cameraHandler;
    private final Fader fader;
    private final Rotator rotator;
    // Player
    private final PlayerMover playerMover;

    public GameLogic() {
        // Enemies
        registerHandler(enemyMover = new EnemyMover());
        registerHandler(enemySpawner = new EnemySpawner());
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(fader = new Fader());
        registerHandler(rotator = new Rotator());
        registerHandler(new StuffMover());
        // Player
        registerHandler(new BoundsHandler());
        registerHandler(playerMover = new PlayerMover());
        registerHandler(new PlayerTracker());
    }

    @Override
    public void update() {
        // Enemies
        enemyMover.update();
        enemySpawner.update();
        // Other
        cameraHandler.update();
        fader.update();
        rotator.update();
        // Player
        playerMover.update();
    }
}