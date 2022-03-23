package app.game;

import app.game.helpers.ObjectPool;
import app.screen.util.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;


public class PowerBoostController extends ObjectPool<PowerBoost> {

    private GameController gc;
    private TextureRegion texture;
    private int type;
    private PowerBoost powerBoost;

    public PowerBoostController(GameController gc) {
        this.gc = gc;
        this.type = MathUtils.random(PowerBoost.PowerBoostType.values().length);
        this.texture = Assets.getInstance()
                .getAtlas()
                .findRegion(PowerBoost.PowerBoostType.values()
                        [type].toString());
    }


    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            PowerBoost powerBoost = activeList.get(i);
            batch.draw(texture, powerBoost.getPosition().x, powerBoost.getPosition().y);
        }
    }

    public void setup(float x, float y, float probability) {
        if (MathUtils.random() <= probability) {
            getActiveElement().activate(PowerBoost.PowerBoostType.values()[MathUtils.random(0,2)], x, y, 12);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }


    @Override
    protected PowerBoost newObject() {
        return new PowerBoost(gc);
    }

    public GameController getGc() {
        return gc;
    }
}
