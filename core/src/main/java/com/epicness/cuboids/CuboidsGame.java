package com.epicness.cuboids;

import com.badlogic.gdx.Game;
import com.epicness.cuboids.game.GameInitializer;
import com.epicness.cuboids.game.assets.GameAssets;
import com.epicness.fundamentals.SharedResources;

public class CuboidsGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initAssets();

        new GameInitializer(assets).initialize(new SharedResources());
    }
}