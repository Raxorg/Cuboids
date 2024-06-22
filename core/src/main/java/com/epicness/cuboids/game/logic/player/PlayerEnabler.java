package com.epicness.cuboids.game.logic.player;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class PlayerEnabler extends GameLogicHandler {

    private Player player;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        disablePlayer();
    }

    public void enablePlayer() {
        player.setColor(WHITE);
        get(PlayerMover.class).setEnabled(true);
    }

    public void disablePlayer() {
        player.setColor(CLEAR);
        get(PlayerMover.class).setEnabled(false);
    }
}