package com.epicness.fundamentals.stuff.shapes.tridimensional;

import com.badlogic.gdx.graphics.g3d.Material;

public abstract class ModelProperties {

    public final Material material;
    public final long attributes;

    public ModelProperties(Material material, long attributes) {
        this.material = material;
        this.attributes = attributes;
    }
}