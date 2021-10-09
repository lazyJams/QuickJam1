package net.lazyio.engine.platformer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.lazyio.engine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Entity> entities = new ArrayList<>();

    private SimpleMap map;

    public World() {
        this.map = new SimpleMap();
    }

    public void render(SpriteBatch batch){
        this.map.render(batch);
    }

    public static void move(Entity entity, float goalX, float goalY){

    }

    public SimpleMap getMap() {
        return map;
    }
}
