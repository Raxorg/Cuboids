package com.epicness.fundamentals.stuff.shapes.tridimensional.cube;

import com.epicness.fundamentals.stuff.shapes.tridimensional.Shape3D;

public class Cube extends Shape3D<CubeCreator, CubeProperties> {

    public Cube(float width, float height, float depth) {
        super(new CubeCreator(width, height, depth));
    }

    @Override
    protected void updateDebugLines() {
        for (index = 0; index < rotationVertices.length; index++) {
            extraIndex = (index + 1) % rotationVertices.length;
            debugLines[index].set(
                rotationVertices[index].x + position.x,
                rotationVertices[index].y + position.y,
                rotationVertices[index].z + position.z,
                rotationVertices[extraIndex].x + position.x,
                rotationVertices[extraIndex].y + position.y,
                rotationVertices[extraIndex].z + position.z
            );
        }
    }
}