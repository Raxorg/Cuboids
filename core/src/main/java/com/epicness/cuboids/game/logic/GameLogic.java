package com.epicness.cuboids.game.logic;

import com.epicness.cuboids.game.logic.other.CameraHandler;
import com.epicness.cuboids.game.logic.player.PlayerMover;
import com.epicness.cuboids.game.logic.player.PlayerTracker;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final CameraHandler cameraHandler;
    private final Rotator rotator;
    private final PlayerMover playerMover;

    public GameLogic() {
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(rotator = new Rotator());
        registerHandler(playerMover = new PlayerMover());
        registerHandler(new PlayerTracker());
    }

    @Override
    public void update() {
        cameraHandler.update();
        rotator.update();
        playerMover.update();
    }
}