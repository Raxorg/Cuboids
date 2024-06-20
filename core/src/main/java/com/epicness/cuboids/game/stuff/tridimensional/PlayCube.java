package com.epicness.cuboids.game.stuff.tridimensional;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector3;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.tridimensional.Screen3D;
import com.epicness.fundamentals.stuff.shapes.tridimensional.plane.Plane;

public class PlayCube {

    private final Screen3D<Plane>[] planes;

    public PlayCube(World2D world2D) {
        //noinspection unchecked
        planes = new Screen3D[6];

        // Front
        planes[0] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[0].getShape().translateZ(2.5f);
        // Back
        planes[1] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[1].getShape().rotateY(180f);
        planes[1].getShape().rotateZ(180f);
        planes[1].getShape().translateZ(2.5f);
        // Bottom
        planes[2] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[2].getShape().rotateX(90f);
        planes[2].getShape().translateZ(2.5f);
        // Top
        planes[3] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[3].getShape().rotateX(-90f);
        planes[3].getShape().translateZ(2.5f);
        // Left
        planes[4] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[4].getShape().rotateY(-90f);
        planes[4].getShape().translateZ(2.5f);
        // Right
        planes[5] = new Screen3D<>(new Plane(5f, 5f), 0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, world2D);
        planes[5].getShape().rotateY(90f);
        planes[5].getShape().translateZ(2.5f);
    }

    @SuppressWarnings("GDXJavaFlushInsideLoop")
    public void draw2D(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer, OrthographicCamera camera) {
        for (int i = 0; i < planes.length; i++) {
            planes[i].draw2D(spriteBatch, shapeDrawer, camera);
        }
    }

    public void draw3D(ModelBatch modelBatch) {
        for (int i = 0; i < planes.length; i++) {
            planes[i].draw3D(modelBatch);
        }
    }

    public void rotateXWise(float degrees) {
        planes[0].getShape().setPosition(Vector3.Zero);
        planes[0].getShape().rotateX(degrees);
        planes[0].getShape().setPosition(0f, 0f, 2.5f);

        planes[1].getShape().setPosition(Vector3.Zero);
        planes[1].getShape().rotateX(degrees);
        planes[1].getShape().setPosition(0f, 0f, 2.5f);

        planes[2].getShape().setPosition(Vector3.Zero);
        planes[2].getShape().rotateX(degrees);
        planes[2].getShape().setPosition(0f, 0f, 2.5f);

        planes[3].getShape().setPosition(Vector3.Zero);
        planes[3].getShape().rotateX(degrees);
        planes[3].getShape().setPosition(0f, 0f, 2.5f);

        planes[4].getShape().setPosition(Vector3.Zero);
        planes[4].getShape().rotateZ(-degrees);
        planes[4].getShape().setPosition(0f, 0f, 2.5f);

        planes[5].getShape().setPosition(Vector3.Zero);
        planes[5].getShape().rotateZ(degrees);
        planes[5].getShape().setPosition(0f, 0f, 2.5f);
    }

    public Screen3D<Plane>[] getPlanes() {
        return planes;
    }
}