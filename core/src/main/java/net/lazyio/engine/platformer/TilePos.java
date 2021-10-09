package net.lazyio.engine.platformer;

/*
 Takes a pixel coordinate and transforms it into a map coordinates.

 Tiles are 16 by 16;

 Coordinates are shifted right by 4.
 128 >> 4 = 8
 */
public class TilePos {

    public int x;
    public int y;

    public TilePos(int x, int y) {
        this.x = x >> 4;
        this.y = y >> 4;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
