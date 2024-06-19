package com.epicness.cuboids.game.logic;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.cuboids.game.stuff.tridimensional.Cuboid;

public class CuboidGenerator extends GameLogicHandler {

    private SnapshotArray<Cuboid> cuboids;
    private World2D world2D;

    @Override
    protected void init() {
        cuboids = stuff.getWorld3D().getCuboids();
        world2D = stuff.getWorld2D();
        generateCuboid();
    }

    public void generateCuboid() {
        Cuboid cuboid = new Cuboid(0, 0, CAMERA_HEIGHT, CAMERA_HEIGHT, world2D);
        cuboids.add(cuboid);
    }
}