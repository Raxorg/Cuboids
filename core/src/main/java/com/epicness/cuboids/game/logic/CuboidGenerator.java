package com.epicness.cuboids.game.logic;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.cuboids.game.stuff.tridimensional.PlayCube;

public class CuboidGenerator extends GameLogicHandler {

    private SnapshotArray<PlayCube> cuboids;
    private World2D world2D;

    @Override
    protected void init() {
        cuboids = stuff.getWorld3D().getCuboids();
        world2D = stuff.getWorld2D();
        generateCuboid();
    }

    public void generateCuboid() {
        PlayCube playCube = new PlayCube(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        playCube.setZRotation(90f);
        cuboids.add(playCube);
    }
}