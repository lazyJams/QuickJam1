package net.lazyio.quickjam;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import net.lazyio.engine.util.AssetProvider;

public class Assets {

    private static final AssetManager manager = new AssetManager();

    public static final AssetProvider<Texture> LIGHT_0 = new AssetProvider<>(manager, "light_0.png", Texture.class);
    public static final AssetProvider<Texture> BADLOGIC = new AssetProvider<>(manager, "badlogic.jpg", Texture.class);
    public static final AssetProvider<Texture> LOGO = new AssetProvider<>(manager, "logo.png", Texture.class);
    public static final AssetProvider<Texture> WHITE = new AssetProvider<>(manager, "white.png", Texture.class);
    public static final AssetProvider<Texture> RED = new AssetProvider<>(manager, "red.png", Texture.class);

    public static void load() {
        manager.finishLoading();
    }

    public static void dispose() {
        manager.dispose();
    }
}
