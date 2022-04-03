package app.screen;

import app.game.GameController;
import app.screen.util.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class GamePauseScreen extends AbstractScreen{



    public GamePauseScreen(SpriteBatch batch) {
        super(batch);
    }

        private BitmapFont font72;
        private BitmapFont font24;
        private Stage stage;
        private StringBuilder sb;
        private GameController gc;


    @Override
    public void pause() {
        super.pause();
    }

    @Override
        public void show() {
            this.stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
            this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf");
            this.font24 = Assets.getInstance().getAssetManager().get("fonts/font24.ttf");

            Gdx.input.setInputProcessor(stage);

            Skin skin = new Skin();
            skin.addRegions(Assets.getInstance().getAtlas());

            TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
            textButtonStyle.up = skin.getDrawable("simpleButton");
            textButtonStyle.font = font24;
            skin.add("simpleSkin", textButtonStyle);

            Button btnNewGame = new TextButton("Continue", textButtonStyle);
            Button btnExitGame = new TextButton("Exit Game", textButtonStyle);
            btnNewGame.setPosition(480, 210);
            btnExitGame.setPosition(480, 110);

            btnNewGame.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.GAME);
                }
            });

            btnExitGame.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Gdx.app.exit();
                }
            });

            stage.addActor(btnNewGame);
            stage.addActor(btnExitGame);
            skin.dispose();

        }

        public void update(float dt) {
            stage.act(dt);
        }


        public void render(float delta) {
            update(delta);
            ScreenUtils.clear(0.0f, 0.0f, 0.2f, 1);
            batch.begin();
            font72.draw(batch, "PAUSE", 0, 600, 1280, 1, false);
            font72.draw(batch, sb.toString(), 0, 500, 1280, 1, false);
            batch.end();
            stage.draw();
        }

        @Override
        public void dispose() {

        }


    }

