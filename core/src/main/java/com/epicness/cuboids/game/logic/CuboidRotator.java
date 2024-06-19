package com.epicness.cuboids.game.logic;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.stuff.tridimensional.Cuboid;

public class CuboidRotator extends GameLogicHandler {

    private SnapshotArray<Cuboid> cuboids;
    private float progress;

    @Override
    protected void init() {
        cuboids = stuff.getWorld3D().getCuboids();
        progress = 1f;
    }

    @Override
    protected void update(float delta) {
        if (progress == 1f) return;

        progress += delta * 2f;
        for (int i = 0; i < cuboids.size; i++) {
            cuboids.get(i).rotate(delta * 90f * 2f);
        }

        if (progress >= 1f) {
            progress = 1f;
        }
    }

    @Override
    public void keyDown(int keycode) {
        if (progress != 1f) return;

        if (keycode == Input.Keys.SPACE) {
            progress = 0f;
        }
    }
}