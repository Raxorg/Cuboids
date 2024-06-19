package com.epicness.cuboids.game;

import com.epicness.cuboids.game.assets.GameAssets;
import com.epicness.cuboids.game.logic.GameLogic;
import com.epicness.cuboids.game.stuff.GameStuff;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}