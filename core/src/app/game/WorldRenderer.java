package app.game;

import app.screen.util.Assets;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font32;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font32 = Assets.getInstance()
                .getAssetManager()
                .get("fonts/font32.ttf", BitmapFont.class);
    }

    public void render () {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gc.getBackground().render(batch);
        gc.getBulletController().render(batch);
        gc.getAsteroidController().render(batch);
        gc.getParticleController().render(batch);
        gc.getHero().render(batch);
        gc.getHero().renderGUI(batch, font32);
        gc.getPowerBoostController().render(batch);
        batch.end();
    }
}
