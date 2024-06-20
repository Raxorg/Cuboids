package com.epicness.cuboids.game.logic.player;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class PlayerTracker extends GameLogicHandler {

    private Player player;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
    }

    public void track() {

    }
}