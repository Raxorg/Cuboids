package com.epicness.cuboids.game.stuff.tridimensional;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;

public class World3D {

    private final SnapshotArray<Cuboid> cuboids;
    private final World2D world2D;

    public World3D(World2D world2D) {
        cuboids = new SnapshotArray<>();
        this.world2D = world2D;
    }

    @SuppressWarnings("GDXJavaFlushInsideLoop")
    public void draw2D(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer, OrthographicCamera camera) {
        for (int i = 0; i < cuboids.size; i++) {
            cuboids.get(i).draw2D(spriteBatch, shapeDrawer, camera);
        }
    }

    public void draw3D(ModelBatch modelBatch) {
        for (int i = 0; i < cuboids.size; i++) {
            cuboids.get(i).draw3D(modelBatch);
        }
    }

    public SnapshotArray<Cuboid> getCuboids() {
        return cuboids;
    }
}