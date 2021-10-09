package net.lazyio.quickjam;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import net.lazyio.quickjam.screen.GameScreen;

import static com.badlogic.gdx.Input.Keys.ESCAPE;
import static net.lazyio.engine.util.gdx.isKeyPressed;

public class Jam extends Game {

    public static Jam instance;

    public static Jam get() {
        return instance;
    }

    @Override
    public void create() {
        instance = this;

        Assets.load();

        this.setScreen(new GameScreen());
    }

    @Override
    public void render() {
        if (isKeyPressed(ESCAPE)) {
            Gdx.app.exit();
        }
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}
