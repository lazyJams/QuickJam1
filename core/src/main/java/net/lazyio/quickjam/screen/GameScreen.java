package net.lazyio.quickjam.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.lazyio.engine.entity.Entity;
import net.lazyio.engine.platformer.TileInfo;
import net.lazyio.engine.platformer.TilePos;
import net.lazyio.engine.platformer.World;
import net.lazyio.quickjam.Assets;
import net.lazyio.engine.graphics.TwoDLight;
import net.lazyio.quickjam.entities.Player;

import static com.badlogic.gdx.Input.Keys.L;
import static net.lazyio.engine.util.gdx.*;

public class GameScreen extends ScreenAdapter {

    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    private TwoDLight light;

    private World world;
    private Player entity;

    @Override
    public void show() {
        this.spriteBatch = new SpriteBatch();
        this.camera = createOrthoCam(500f);

        this.light = new TwoDLight(new Vector2(100, 100), new Vector2(150, 150));

        this.world = new World();
        this.world.getMap().tileData.put(1, new TileInfo(Assets.WHITE.get()));

    }

    @Override
    public void render(float delta) {

        clear();

        if (isKeyPressed(L)) {
            this.light.begin(spriteBatch, camera);
            this.spriteBatch.begin();
            this.spriteBatch.draw(Assets.BADLOGIC.get(), 100f, 100f);
            this.spriteBatch.end();
            this.light.end(spriteBatch);
        }

        this.spriteBatch.setProjectionMatrix(camera.combined);
        this.spriteBatch.begin();
        this.world.render(spriteBatch);
        this.spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        updateCamera(camera, width, height, 500f);
        light.resize(width, height);
    }

    @Override
    public void dispose() {
        light.dispose();
        spriteBatch.dispose();
    }
}
