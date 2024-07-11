package com.epicness.cuboids.game.logic.player;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.Text;

public class PlayerEnabler extends GameLogicHandler {

    private Player player;
    private Text freeMovementText;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        freeMovementText = stuff.getFreeMovementText();
        disablePlayer();
    }

    public void enablePlayer() {
        player.setColor(WHITE);
        get(PlayerMover.class).setEnabled(true);
        freeMovementText.setText("Touch a spawner to disable damage from it");
        freeMovementText.setY(freeMovementText.getHeight() + 10f);
        freeMovementText.setX(CAMERA_HALF_WIDTH);
    }

    public void disablePlayer() {
        player.setColor(CLEAR);
        freeMovementText.setText("");
        get(PlayerMover.class).setEnabled(false);
    }
}