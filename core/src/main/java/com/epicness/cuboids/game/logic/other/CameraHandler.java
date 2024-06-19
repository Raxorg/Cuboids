package com.epicness.cuboids.game.logic.other;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.epicness.cuboids.game.logic.GameLogicHandler;

public class CameraHandler extends GameLogicHandler {

    @Override
    protected void init() {
        PerspectiveCamera camera = renderer.getPerspectiveCamera();
        camera.direction.set(0f, 0f, -1f);
        camera.up.set(0, 1, 0);
        camera.position.set(0f, 0f, 15.5f);
        camera.update();
    }
}