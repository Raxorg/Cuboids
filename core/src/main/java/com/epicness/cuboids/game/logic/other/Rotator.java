package com.epicness.cuboids.game.logic.other;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.tridimensional.PlayCube;
import com.epicness.fundamentals.logic.CompletionListener;

public class Rotator extends GameLogicHandler {

    private PlayCube playCube;
    private float xRotation;
    private boolean rotating;
    private CompletionListener listener;

    @Override
    protected void init() {
        playCube = stuff.getWorld3D().getPlayCube();
        xRotation = 0f;
        rotating = false;
    }

    @Override
    protected void update(float delta) {
        if (!rotating) return;

        float rotation = delta * 500f;
        playCube.rotateXWise(rotation);
        xRotation += rotation;

        if (xRotation >= 90f) {
            playCube.rotateXWise(90f - xRotation);
            xRotation = 0f;
            rotating = false;
            listener.onComplete();
        }
    }

    public void rotateDown(CompletionListener listener) {
        if (rotating) return;

        rotating = true;
        this.listener = listener;
    }
}