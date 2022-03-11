package app.game;

import app.game.helpers.ObjectPool;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AsteroidController extends ObjectPool<Asteroid> {


    private final int ASTEROID_COUNT = 5;
    private Texture textureAsteroid;

    private Asteroid[] asteroids;

    @Override
    protected Asteroid newObject() {
        return new Asteroid();
    }

    public AsteroidController() {
        this.textureAsteroid = new Texture("asteroid.png");
        this.asteroids = new Asteroid[ASTEROID_COUNT];
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < asteroids.length; i++) {
            batch.draw(textureAsteroid, asteroids[i].getPosition().x - 128, asteroids[i].getPosition().y - 128, 128, 128,
                    256, 256, asteroids[i].getScale(), asteroids[i].getScale(),
                    0, 0, 0, 256, 256, false, false);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i].update(dt);
        }
    }
}
