package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.GameConstants.INITIAL_LIVES;
import static com.epicness.cuboids.game.GameConstants.LIFE_RADIUS;
import static com.epicness.cuboids.game.GameConstants.LIFE_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class LifeHandler extends GameLogicHandler {

    private SnapshotArray<Circle> lives;

    @Override
    protected void init() {
        lives = stuff.getLives();
        lives.clear();
        for (int i = 0; i < INITIAL_LIVES; i++) {
            lives.add(new Circle(10f + LIFE_SIZE * i + 10f * i, CAMERA_HEIGHT - LIFE_SIZE - 10f, LIFE_RADIUS));
        }
    }

    public void loseLife() {
        lives.removeIndex(lives.size - 1);
        if (lives.isEmpty()) {
            // todo: restart wave
        }
    }
}