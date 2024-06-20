package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.GameConstants.PLAYER_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.Fader;
import com.epicness.cuboids.game.logic.other.Rotator;
import com.epicness.cuboids.game.stuff.bidimensional.Player;
import com.epicness.cuboids.game.stuff.tridimensional.PlayCube;

public class PlayerTracker extends GameLogicHandler {

    private Player player;
    private PlayCube playCube;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        playCube = stuff.getWorld3D().getPlayCube();
    }

    public void trackPlayer() {
        if (player.getY() <= 0f) {
            get(PlayerMover.class).setEnabled(false);
            get(Fader.class).fadeOut(() -> {
                player.setY(CAMERA_HEIGHT - PLAYER_SIZE);
                playCube.rotateXWise(-90f);
                get(Rotator.class).rotateDown(() -> get(Fader.class).fadeIn(() -> get(PlayerMover.class).setEnabled(true)));
            });
        }
    }
}