package com.epicness.cuboids.game.stuff;

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
    private Text waveText;

    @Override
    public void initializeStuff() {
        world2D = new World2D();
        world3D = new World3D(world2D);
        lives = new SnapshotArray<>();
        waveText = new Text(sharedAssets.getTimesSquare());
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
}