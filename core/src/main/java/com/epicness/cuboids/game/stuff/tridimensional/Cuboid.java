package com.epicness.cuboids.game.stuff.tridimensional;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.tridimensional.Screen3D;
import com.epicness.fundamentals.stuff.shapes.tridimensional.cube.Cube;

public class Cuboid {

    private final Screen3D<Cube> cube;

    public Cuboid(float offsetX2D, float offsetY2D, float cameraWidth, float cameraHeight, World2D world2D) {
        cube = new Screen3D<>(new Cube(5f, 5f, 5f), offsetX2D, offsetY2D, cameraWidth, cameraHeight, world2D);

    }

    public void draw2D(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer, OrthographicCamera camera) {
        cube.draw2D(spriteBatch, shapeDrawer, camera);
    }

    public void draw3D(ModelBatch modelBatch) {
        cube.draw3D(modelBatch);
    }

    public void rotate(float degrees) {
        cube.getShape().rotateX(degrees);
    }
}