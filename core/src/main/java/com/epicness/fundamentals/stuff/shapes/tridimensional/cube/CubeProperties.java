package com.epicness.fundamentals.stuff.shapes.tridimensional.cube;

import static com.epicness.fundamentals.constants.Constants3D.MATERIAL_ID;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.epicness.fundamentals.constants.Constants3D;
import com.epicness.fundamentals.stuff.shapes.tridimensional.ModelProperties;

public class CubeProperties extends ModelProperties {

    public final float width, height, depth;


    public CubeProperties(float width, float height, float depth, Material material, long attributes) {
        super(material, attributes);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public CubeProperties(float width, float height, float depth) {
        this(
            width, height, depth,
            new Material(MATERIAL_ID, new BlendingAttribute(), IntAttribute.createCullFace(GL20.GL_NONE)),
            Constants3D.LIGHTLESS_TEXTURED_ATTRIBUTES
        );
    }
}