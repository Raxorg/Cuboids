package com.epicness.cuboids.game.logic;

import com.epicness.cuboids.game.logic.other.CameraHandler;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final CameraHandler cameraHandler;
    private final Rotator rotator;
    private final PlayerHandler playerHandler;

    public GameLogic() {
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(rotator = new Rotator());
        registerHandler(playerHandler = new PlayerHandler());
    }

    @Override
    public void update() {
        cameraHandler.update();
        rotator.update();
        playerHandler.update();
    }
}