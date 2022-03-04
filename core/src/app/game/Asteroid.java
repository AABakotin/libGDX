package app.game;

import app.game.helpers.Poolable;
import app.screen.ScreenManager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static app.screen.ScreenManager.SCREEN_HEIGHT;
import static app.screen.ScreenManager.SCREEN_WIDTH;


public class Asteroid implements Poolable {
        private Vector2 position;
        private Vector2 velocity;
        private float scale;

        public Asteroid() {
            this.position = new Vector2(MathUtils.random(-200, SCREEN_WIDTH + 200),
                    MathUtils.random(-200, SCREEN_HEIGHT + 200));
            this.velocity = new Vector2(MathUtils.random(-40, -5),MathUtils.random(-40, -5));
            scale = Math.abs(velocity.x / 40f) * 0.8f;
        }

        public void update(float dt) {
            position.x += velocity.x * 7.5f * dt;
            position.y += velocity.y * 7.5f * dt;
            if (position.x < -256) {
                position.x = ScreenManager.SCREEN_WIDTH + 256;
                position.y = MathUtils.random(0, ScreenManager.SCREEN_HEIGHT);
                scale = Math.abs(velocity.x) / 40.0f * 0.7f;
            }
        }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getScale() {
        return scale;
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
