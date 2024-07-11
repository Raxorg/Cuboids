package com.epicness.cuboids.game.logic.spawns;

import static com.badlogic.gdx.Input.Keys.T;
import static com.badlogic.gdx.graphics.Color.CYAN;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.OLIVE;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PINK;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.cuboids.game.constants.GameConstants.PLAYER_RADIUS;
import static com.epicness.cuboids.game.constants.GameConstants.SPAWN_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.cuboids.game.stuff.bidimensional.EnemySpawn;
import com.epicness.cuboids.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.Text;

public class SpawnChooser extends GameLogicHandler {

    private SnapshotArray<EnemySpawn> spawns;
    private Player player;
    private Text freeMovementText;
    private Vector2 playerCenter, spawnCenter;

    @Override
    protected void init() {
        spawns = stuff.getWorld2D().getSpawns();
        player = stuff.getWorld2D().getPlayer();
        freeMovementText = stuff.getFreeMovementText();
        playerCenter = new Vector2();
        spawnCenter = new Vector2();
    }

    public void checkProximity() {
        for (int i = 0; i < spawns.size; i++) {
            player.getCenter(playerCenter);
            spawns.get(i).getCenter(spawnCenter);
            if (Gdx.input.isKeyPressed(T)) {
                System.out.println(playerCenter + " ~ " + spawnCenter);
            }
            if (playerCenter.dst(spawnCenter) <= SPAWN_SIZE - PLAYER_RADIUS) {
                spawnChosen(spawns.get(i));
                return;
            }
        }
    }

    private void spawnChosen(EnemySpawn spawn) {
        resetSpawnColors();

        spawn.setColor(WHITE);
        spawn.originalColor.set(WHITE);

        freeMovementText.setText("Go back to base");
        freeMovementText.setY(freeMovementText.getHeight() + 10f);
        freeMovementText.setX(CAMERA_WIDTH - freeMovementText.getPlainWidth() - 10f);
    }

    public void resetSpawnColors() {
        spawns.get(0).setColor(CYAN);
        spawns.get(0).originalColor.set(CYAN);

        spawns.get(1).setColor(RED);
        spawns.get(1).originalColor.set(RED);

        spawns.get(2).setColor(GREEN);
        spawns.get(2).originalColor.set(GREEN);

        spawns.get(3).setColor(YELLOW);
        spawns.get(3).originalColor.set(YELLOW);

        spawns.get(4).setColor(ORANGE);
        spawns.get(4).originalColor.set(ORANGE);

        spawns.get(5).setColor(PURPLE);
        spawns.get(5).originalColor.set(PURPLE);

        spawns.get(6).setColor(OLIVE);
        spawns.get(6).originalColor.set(OLIVE);

        spawns.get(7).setColor(PINK);
        spawns.get(7).originalColor.set(PINK);
    }
}