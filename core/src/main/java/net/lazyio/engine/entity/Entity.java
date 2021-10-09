package net.lazyio.engine.entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Entity {

    public String tag;
    public Vector2 pos;
    public Vector2 vel = new Vector2();
    public Vector2 size;
    public Rectangle boundingBox;
    
    public Entity(Vector2 pos, Vector2 size, String tag) {
        this.pos = pos;
        this.size = size;
        this.tag = tag;
        this.boundingBox = new Rectangle(this.pos.x, this.pos.y, this.size.x, this.size.y);
    }
}
