package com.epicness.cuboids.game.logic.player;

import static com.epicness.cuboids.game.constants.GameConstants.PLAYER_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.logic.base.BaseHandler;
import com.epicness.cuboids.game.logic.spawns.SpawnChooser;
import com.epicness.cuboids.game.stuff.bidimensional.Player;

public class PlayerMover extends GameLogicHandler {

    private Player player;
    private boolean enabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;
        pollInput();

        player.speed.scl(PLAYER_SPEED * delta);
        player.translate(player.speed);

        get(SpawnChooser.class).checkProximity();
        get(BoundsHandler.class).checkBounds();
        get(PlayerTracker.class).trackPlayer();
        get(BaseHandler.class).checkProximity();
    }

    private void pollInput() {
        player.speed.setZero();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.speed.x -= 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.speed.x += 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.speed.y += 1f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.speed.y -= 1f;
        }

        player.speed.nor();
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}