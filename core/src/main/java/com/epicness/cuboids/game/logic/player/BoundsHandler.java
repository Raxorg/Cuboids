package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.GameConstants.PLAYER_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.LinePlus;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class BoundsHandler extends GameLogicHandler {

    private Player player;
    private LinePlus[] lines;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        lines = stuff.getWorld2D().getLines();
    }

    public void checkBounds() {
        // Top
        if (player.getY() + PLAYER_SIZE > lines[0].getY()) {
            player.setY(lines[0].getY() - PLAYER_SIZE);
        }
        // Bottom
        if (player.getY() < lines[6].getY()) {
            player.setY(lines[6].getY());
        }
        // Right
        if (player.getX() + PLAYER_SIZE > CAMERA_WIDTH * 2f) {
            player.setX(CAMERA_WIDTH * 2f - PLAYER_SIZE);
        }
        // Left
        if (player.getX() < -CAMERA_WIDTH) {
            player.setX(-CAMERA_WIDTH);
        }
    }
}