package com.epicness.fundamentals.stuff.shapes.tridimensional.cube;

import com.badlogic.gdx.graphics.g3d.Model;
import com.epicness.fundamentals.stuff.shapes.tridimensional.ModelCreator;

public class CubeCreator extends ModelCreator<CubeProperties> {

    protected CubeCreator(float width, float height, float depth) {
        super(new CubeProperties(width, height, depth));
    }

    @Override
    protected Model build(CubeProperties properties) {
        return modelBuilder.createBox(
            properties.width,
            properties.height,
            properties.depth,
            properties.material,
            properties.attributes
        );
    }
}