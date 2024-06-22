package com.epicness.cuboids.game.assets;

import static com.epicness.cuboids.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Sound;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Sound do1;

    private Sound do2;

    private Sound fa;

    private Sound la;

    private Sound mi;

    private Sound re;

    private Sound si;

    private Sound sol;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        do1 = get(DO1_SOUND);
        do2 = get(DO2_SOUND);
        fa = get(FA_SOUND);
        la = get(LA_SOUND);
        mi = get(MI_SOUND);
        re = get(RE_SOUND);
        si = get(SI_SOUND);
        sol = get(SOL_SOUND);
    }

    public Sound getDo1() {
        return do1;
    }

    public Sound getDo2() {
        return do2;
    }

    public Sound getFa() {
        return fa;
    }

    public Sound getLa() {
        return la;
    }

    public Sound getMi() {
        return mi;
    }

    public Sound getRe() {
        return re;
    }

    public Sound getSi() {
        return si;
    }

    public Sound getSol() {
        return sol;
    }
}