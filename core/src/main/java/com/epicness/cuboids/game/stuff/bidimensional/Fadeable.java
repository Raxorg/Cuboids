package com.epicness.cuboids.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.Color;

public abstract class Fadeable {

    public final Color originalColor = new Color(1f, 1f, 1f, 1f);

    public abstract void setColor(Color color);
}