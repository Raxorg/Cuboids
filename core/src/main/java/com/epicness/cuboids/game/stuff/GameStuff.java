package com.epicness.cuboids.game.stuff;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.utils.TextUtils.copyOf;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.cuboids.game.assets.GameAssets;
import com.epicness.cuboids.game.stuff.bidimensional.World2D;
import com.epicness.cuboids.game.stuff.tridimensional.World3D;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class GameStuff extends Stuff<GameAssets> {

    private World2D world2D;
    private World3D world3D;
    private SnapshotArray<Circle> lives;
    private Text waveText, freeMovementText, instructionsText;

    @Override
    public void initializeStuff() {
        world2D = new World2D(sharedAssets);
        world3D = new World3D(world2D);
        lives = new SnapshotArray<>();
        waveText = new Text(sharedAssets.getTimesSquare());

        freeMovementText = new Text(copyOf(sharedAssets.getTimesSquare()));
        freeMovementText.setScale(0.7f);

        instructionsText = new Text(copyOf(sharedAssets.getTimesSquare()));
        instructionsText.setText("WASD or ARROWS to play/move\ndiagonal arrows accept both directions, I to toggle, F to start");
        instructionsText.setScale(0.7f);
        instructionsText.setY(CAMERA_HEIGHT - 10f);
        instructionsText.setX(CAMERA_HALF_WIDTH - 240f);
        instructionsText.setWidth(CAMERA_HALF_WIDTH + 240f - 10f);
    }

    public World2D getWorld2D() {
        return world2D;
    }

    public World3D getWorld3D() {
        return world3D;
    }

    public SnapshotArray<Circle> getLives() {
        return lives;
    }

    public Text getWaveText() {
        return waveText;
    }

    public Text getFreeMovementText() {
        return freeMovementText;
    }

    public Text getInstructionsText() {
        return instructionsText;
    }
}