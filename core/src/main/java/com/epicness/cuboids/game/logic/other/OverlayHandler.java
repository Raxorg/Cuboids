package com.epicness.cuboids.game.logic.other;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class OverlayHandler extends GameLogicHandler {

    private Rectangle overlay;
    private Color initialColor, transitionColor;
    private float progress;

    @Override
    protected void init() {
        overlay = stuff.getWorld2D().getOverlay();
        initialColor = new Color();
        transitionColor = new Color();
        progress = 0f;
        hide();
    }

    @Override
    protected void update(float delta) {
        if (progress == 1f) return;

        progress = Math.min(progress + delta * 3f, 1f);
        overlay.setColor(transitionColor.set(initialColor).lerp(CLEAR, progress));
    }

    public void appear(Color color) {
        overlay.setColor(color);
        initialColor.set(color);
        progress = 0f;
    }

    public void hide() {
        overlay.setColor(CLEAR);
    }
}