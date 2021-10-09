package net.lazyio.engine.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import net.lazyio.engine.util.gdx;
import net.lazyio.quickjam.Assets;

public class TwoDLight {

    private FrameBuffer lightBuffer;
    private Sprite light;

    private float tmp = 150f;

    public TwoDLight(Vector2 pos, Vector2 size) {
        this.light = new Sprite(Assets.LIGHT_0.get());
        this.light.setBounds(pos.x, pos.y, size.x, size.y);
    }

    public void begin(SpriteBatch spriteBatch, OrthographicCamera camera) {
        lightBuffer.begin();

        gdx.clear();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE);
        spriteBatch.begin();
        light.draw(spriteBatch);
        spriteBatch.end();

        lightBuffer.end();

        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void end(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(spriteBatch.getProjectionMatrix().idt());
        spriteBatch.setBlendFunction(GL20.GL_ZERO, GL20.GL_SRC_COLOR);
        spriteBatch.begin();
        spriteBatch.draw(lightBuffer.getColorBufferTexture(), -1, 1, 2, -2);
        spriteBatch.end();
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void resize(int width, int height) {
        if (lightBuffer != null && (lightBuffer.getWidth() != width || lightBuffer.getHeight() != height)) {
            lightBuffer.dispose();
            lightBuffer = null;
        }

        if (lightBuffer == null) {
            try {
                lightBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
            } catch (GdxRuntimeException e) {
                lightBuffer = new FrameBuffer(Pixmap.Format.RGB565, width, height, false);
            }
        }
    }

    public void dispose() {
        this.lightBuffer.dispose();
    }
}
