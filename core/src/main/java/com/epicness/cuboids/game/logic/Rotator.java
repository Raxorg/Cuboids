package com.epicness.cuboids.game.logic;

import static com.badlogic.gdx.Input.Keys.F;

import com.epicness.cuboids.game.stuff.tridimensional.PlayCube;

public class Rotator extends GameLogicHandler {

    private PlayCube playCube;
    private float xRotation;
    private boolean rotating;

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
        }
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == F) {
            rotating = true;
        }
    }
}