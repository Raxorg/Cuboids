package com.epicness.cuboids.game.logic.other;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.utils.Array;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.interfaces.Movable;

public class StuffMover extends GameLogicHandler {

    private Array<Movable> movables;

    @Override
    protected void init() {
        movables = new Array<>();
        movables.addAll(stuff.getWorld2D().getTests());
        movables.addAll(stuff.getWorld2D().getLines());
        movables.add(stuff.getWorld2D().getBase());
    }

    public void moveDown() {
        for (int i = 0; i < movables.size; i++) {
            movables.get(i).translateY(CAMERA_HEIGHT);
        }
    }

    public void moveUp() {
        for (int i = 0; i < movables.size; i++) {
            movables.get(i).translateY(-CAMERA_HEIGHT);
        }
    }
}