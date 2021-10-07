package net.lazyio.engine.entity;

import com.badlogic.gdx.math.Vector2;

public class Entity {

    public String tag;

    public Vector2 pos;
    public Vector2 vel = new Vector2();
    public Vector2 size;
    public Vector2 bbOff = new Vector2();
    public Vector2 itemPos = new Vector2();
    
    public Entity(Vector2 pos, Vector2 size, String tag) {
        this.pos = pos;
        this.itemPos.set(pos.x + bbOff.x, pos.y + this.bbOff.y);
        this.size = size;
        this.tag = tag;
    }
}
