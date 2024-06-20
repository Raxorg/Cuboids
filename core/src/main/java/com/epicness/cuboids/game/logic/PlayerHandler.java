package com.epicness.cuboids.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class PlayerHandler extends GameLogicHandler {

    private Player player;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
    }

    @Override
    protected void update(float delta) {
        pollInput();

        player.speed.scl(500f * delta);
        player.translate(player.speed);
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