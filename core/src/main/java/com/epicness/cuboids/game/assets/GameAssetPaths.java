package com.epicness.cuboids.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<Sound> DO1_SOUND;

    public static final AssetDescriptor<Sound> DO2_SOUND;

    public static final AssetDescriptor<Sound> FA_SOUND;

    public static final AssetDescriptor<Sound> LA_SOUND;

    public static final AssetDescriptor<Sound> MI_SOUND;

    public static final AssetDescriptor<Sound> RE_SOUND;

    public static final AssetDescriptor<Sound> SI_SOUND;

    public static final AssetDescriptor<Sound> SOL_SOUND;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(DO1_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/do1.swav", Sound.class));
        ASSETS.add(DO2_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/do2.swav", Sound.class));
        ASSETS.add(FA_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/fa.swav", Sound.class));
        ASSETS.add(LA_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/la.swav", Sound.class));
        ASSETS.add(MI_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/mi.swav", Sound.class));
        ASSETS.add(RE_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/re.swav", Sound.class));
        ASSETS.add(SI_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/si.swav", Sound.class));
        ASSETS.add(SOL_SOUND = new AssetDescriptor<>("cuboids/game/audios/sounds/sol.swav", Sound.class));
    }
}