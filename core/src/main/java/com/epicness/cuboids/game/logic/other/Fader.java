package com.epicness.cuboids.game.logic.other;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;
import com.epicness.cuboids.game.stuff.bidimensional.Fadeable;
import com.epicness.fundamentals.logic.CompletionListener;

public class Fader extends GameLogicHandler {

    private Array<Fadeable> fadeables;
    private Array<Enemy> enemies;
    private float progress;
    private boolean fadeIn;
    private Color aux;
    private CompletionListener listener;

    @Override
    protected void init() {
        fadeables = new Array<>();
        fadeables.add(stuff.getWorld2D().getPlayer());
        fadeables.addAll(stuff.getWorld2D().getSpawns());
        fadeables.addAll(stuff.getWorld2D().getLines());
        fadeables.add(stuff.getWorld2D().getBase());

        enemies = stuff.getWorld2D().getEnemies();
        progress = 1f;
        aux = new Color();
    }

    @Override
    protected void update(float delta) {
        if (progress == 1f) return;

        progress = Math.min(progress + delta * 5f, 1f);
        for (int i = 0; i < fadeables.size; i++) {
            fade(fadeables.get(i));
        }
        for (int i = 0; i < enemies.size; i++) {
            fade(enemies.get(i));
        }

        if (progress == 1f) listener.onComplete();
    }

    private void fade(Fadeable fadeable) {
        if (fadeIn) {
            fadeable.setColor(aux.set(CLEAR).lerp(fadeable.originalColor, progress));
        } else {
            fadeable.setColor(aux.set(fadeable.originalColor).lerp(CLEAR, progress));
        }
    }

    public void fadeOut(CompletionListener listener) {
        if (progress != 1f) return;

        progress = 0f;
        fadeIn = false;
        this.listener = listener;
    }

    public void fadeIn(CompletionListener listener) {
        if (progress != 1f) return;

        progress = 0f;
        fadeIn = true;
        this.listener = listener;
    }
}