package com.epicness.cuboids.game.logic;

import com.epicness.cuboids.game.logic.other.CameraHandler;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final CuboidRotator cuboidRotator;
    private final PlayerHandler playerHandler;

    public GameLogic() {
        registerHandler(new CameraHandler());
        registerHandler(new CuboidGenerator());
        registerHandler(cuboidRotator = new CuboidRotator());
        registerHandler(playerHandler = new PlayerHandler());
    }

    @Override
    public void update() {
        cuboidRotator.update();
        playerHandler.update();
    }
}