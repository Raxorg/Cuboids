package com.epicness.cuboids.game.logic.other;

import static com.badlogic.gdx.Input.Keys.C;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;
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

    @Override
    protected void update(float delta) {
        if (!Gdx.input.isKeyPressed(C)) return;

        PerspectiveCamera camera = renderer.getPerspectiveCamera();
        camera.rotateAround(Vector3.Zero, Vector3.X, delta * 45f);
        camera.rotateAround(Vector3.Zero, Vector3.Y, delta * 45f);
        camera.update();
    }
}