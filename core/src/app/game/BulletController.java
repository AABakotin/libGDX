package app.game;

import app.game.helpers.ObjectPool;
import app.screen.util.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class BulletController extends ObjectPool<Bullet> {
    private TextureRegion bulletTexture;
    private GameController gc;

    @Override
    protected Bullet newObject() {
        return new Bullet(gc);
    }

    public BulletController(GameController gc) {
        this.gc = gc;
        this.bulletTexture = Assets.getInstance().getAtlas().findRegion("bullet");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Bullet b = activeList.get(i);
            batch.draw(bulletTexture, b.getPosition().x - 16, b.getPosition().y - 16);
        }
    }

    public void setup(float x, float y, float vx, float vy){
        getActiveElement().activate(x, y, vx, vy);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
