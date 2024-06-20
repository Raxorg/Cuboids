package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.GameConstants.PLAYER_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class PlayerMover extends GameLogicHandler {

    private Player player;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
    }

    @Override
    protected void update(float delta) {
        pollInput();

        player.speed.scl(PLAYER_SPEED * delta);
        player.translate(player.speed);

        get(PlayerTracker.class).track();
    }

    private void pollInput() {
        player.speed.setZero();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.speed.x -= 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.speed.x += 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.speed.y += 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.speed.y -= 1f;
        }

        player.speed.nor();
    }
}