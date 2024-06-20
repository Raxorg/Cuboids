package com.epicness.cuboids.game.stuff.tridimensional;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;

public class World3D {

    private final PlayCube playCube;
    private final World2D world2D;

    public World3D(World2D world2D) {
        playCube = new PlayCube(world2D);
        this.world2D = world2D;
    }

    public void draw2D(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer, OrthographicCamera camera) {
        playCube.draw2D(spriteBatch, shapeDrawer, camera);
    }

    public void draw3D(ModelBatch modelBatch) {
        playCube.draw3D(modelBatch);
    }

    public PlayCube getPlayCube() {
        return playCube;
    }
}