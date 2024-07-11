package com.epicness.cuboids.game.logic;

import com.epicness.cuboids.game.logic.base.BaseHandler;
import com.epicness.cuboids.game.logic.enemies.EnemyMover;
import com.epicness.cuboids.game.logic.enemies.EnemySpawner;
import com.epicness.cuboids.game.logic.enemies.WaveHandler;
import com.epicness.cuboids.game.logic.enemies.WaveTextHandler;
import com.epicness.cuboids.game.logic.enemies.WaveTracker;
import com.epicness.cuboids.game.logic.other.CameraHandler;
import com.epicness.cuboids.game.logic.other.Fader;
import com.epicness.cuboids.game.logic.other.OverlayHandler;
import com.epicness.cuboids.game.logic.other.Rotator;
import com.epicness.cuboids.game.logic.other.SoundHandler;
import com.epicness.cuboids.game.logic.other.StuffMover;
import com.epicness.cuboids.game.logic.player.BoundsHandler;
import com.epicness.cuboids.game.logic.player.LifeHandler;
import com.epicness.cuboids.game.logic.player.NoteHandler;
import com.epicness.cuboids.game.logic.player.PlayerEnabler;
import com.epicness.cuboids.game.logic.player.PlayerMover;
import com.epicness.cuboids.game.logic.player.PlayerTracker;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Enemies
    private final EnemyMover enemyMover;
    private final WaveHandler waveHandler;
    // Other
    private final CameraHandler cameraHandler;
    private final Fader fader;
    private final OverlayHandler overlayHandler;
    private final Rotator rotator;
    // Player
    private final PlayerMover playerMover;

    public GameLogic() {
        // Base
        registerHandler(new BaseHandler());
        // Enemies
        registerHandler(enemyMover = new EnemyMover());
        registerHandler(waveHandler = new WaveHandler());
        registerHandler(new EnemySpawner());
        registerHandler(new WaveTextHandler());
        registerHandler(new WaveTracker());
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(fader = new Fader());
        registerHandler(overlayHandler = new OverlayHandler());
        registerHandler(rotator = new Rotator());
        registerHandler(new SoundHandler());
        registerHandler(new StuffMover());
        // Player
        registerHandler(new LifeHandler());
        registerHandler(new NoteHandler());
        registerHandler(new BoundsHandler());
        registerHandler(new PlayerEnabler());
        registerHandler(playerMover = new PlayerMover());
        registerHandler(new PlayerTracker());
    }

    @Override
    public void update() {
        // Enemies
        enemyMover.update();
        waveHandler.update();
        // Other
        cameraHandler.update();
        fader.update();
        overlayHandler.update();
        rotator.update();
        // Player
        playerMover.update();
    }
}