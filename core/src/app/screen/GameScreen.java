package app.screen;

import app.game.GameController;
import app.game.WorldRenderer;
import app.screen.util.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen extends AbstractScreen{
    private GameController gc;
    private WorldRenderer worldRenderer;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gc = new GameController();
        this.worldRenderer = new WorldRenderer(gc, batch);
    }

    @Override
    public void render(float delta) {
        gc.update(delta);
        worldRenderer.render();
    }
}
