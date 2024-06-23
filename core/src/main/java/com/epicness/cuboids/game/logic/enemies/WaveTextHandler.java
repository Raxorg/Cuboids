package com.epicness.cuboids.game.logic.enemies;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.Text;

public class WaveTextHandler extends GameLogicHandler {

    private Text waveText;

    @Override
    protected void init() {
        waveText = stuff.getWaveText();
        setWave(1);
    }

    public void setWave(int wave) {
        waveText.setText("Wave " + wave + "/10");
        waveText.setPosition(10f, waveText.getHeight() + 10f);
    }
}