package com.epicness.cuboids.game.logic.other;

import com.badlogic.gdx.audio.Sound;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Enemy;

public class SoundHandler extends GameLogicHandler {

    @Override
    protected void init() {
    }

    public Sound getSound(Enemy enemy) {
        switch (enemy.direction) {
            case UP:
                return assets.getDo1();
            case UP_RIGHT:
                return assets.getRe();
            case RIGHT:
                return assets.getMi();
            case DOWN_RIGHT:
                return assets.getFa();
            case DOWN:
                return assets.getSol();
            case DOWN_LEFT:
                return assets.getLa();
            case LEFT:
                return assets.getSi();
            case UP_LEFT:
            default:
                return assets.getDo2();
        }
    }
}