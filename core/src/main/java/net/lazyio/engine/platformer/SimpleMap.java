package net.lazyio.engine.platformer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

public class SimpleMap {

    private static final int TILE_SIZE = 16;

    private int WIDTH = 100;
    private int HEIGHT = 100;

    private int[][] map = new int[WIDTH][HEIGHT];

    public Map<Integer, TileInfo> tileData = new HashMap<>();

    public int getTile(TilePos pos) {
        return this.map[pos.x][pos.y];
    }

    private int internalGetTile(int x, int y) {
        return this.map[x][y];
    }

    public void putTile(TilePos pos, int tile) {
        this.map[pos.x][pos.y] = tile;
    }

    public void putTileDirect(int x, int y, int tile) {
        this.map[x][y] = tile;
    }


    public void render(SpriteBatch batch) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int i = this.internalGetTile(x, y);
                if (i != 0)
                    batch.draw(this.tileData.get(i).texture, x << 4, y << 4);
            }
        }
    }
}
