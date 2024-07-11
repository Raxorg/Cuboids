package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.constants.GameConstants.PLAYER_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.other.Fader;
import com.epicness.cuboids.game.logic.other.Rotator;
import com.epicness.cuboids.game.logic.other.StuffMover;
import com.epicness.cuboids.game.stuff.bidimensional.Player;
import com.epicness.cuboids.game.stuff.tridimensional.PlayCube;
import com.epicness.fundamentals.logic.CompletionListener;

public class PlayerTracker extends GameLogicHandler {

    private Player player;
    private PlayCube playCube;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        playCube = stuff.getWorld3D().getPlayCube();
    }

    public void trackPlayer() {
        if (player.getY() < 0f) {
            beginTransition(this::transitionDown);
        } else if (player.getY() + PLAYER_SIZE > CAMERA_HEIGHT) {
            beginTransition(this::transitionUp);
        }
    }

    private void beginTransition(CompletionListener listener) {
        get(PlayerMover.class).setEnabled(false);
        get(Fader.class).fadeOut(listener);
    }

    private void transitionDown() {
        player.setY(CAMERA_HEIGHT - PLAYER_SIZE);
        playCube.rotateXWise(90f);
        get(Rotator.class).rotateDown(() -> {
                get(StuffMover.class).moveDown();
                get(Fader.class).fadeIn(() -> get(PlayerMover.class).setEnabled(true));
            }
        );
    }

    private void transitionUp() {
        player.setY(0f);
        playCube.rotateXWise(-90f);
        get(Rotator.class).rotateUp(() -> {
                get(StuffMover.class).moveUp();
                get(Fader.class).fadeIn(() -> get(PlayerMover.class).setEnabled(true));
            }
        );
    }
}