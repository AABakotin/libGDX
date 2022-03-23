package app.game;

import app.game.helpers.Poolable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class PowerBoost implements Poolable {

    public enum PowerBoostType {
        HEALT(0),
        AMMO(1),
        MONEY(2);
        int index;

        PowerBoostType(int index) {
            this.index = index;
        }
    }

    private GameController gc;
    private boolean active;
    private Circle hitArea;
    private float scale;
    private int power;
    private float time;
    private Vector2 position;
    private PowerBoostType boostType;


    public PowerBoost(GameController gc) {
        this.gc = gc;
        this.active = false;
        this.position = new Vector2(0, 0);
        this.hitArea = new Circle(0, 0, 50);

    }

    public void activate(PowerBoostType boostType, float x, float y, int power) {
        this.boostType = boostType;
        this.position.set(x, y);
        this.active = true;
        this.power = power;
        this.time = 0.0f;
        this.hitArea.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }


    public void update(float dt) {
        time += dt;
        if (time >= 5.5f) {
            deactivate();
        }
    }

    public void deactivate() {
        active = false;
    }

    public GameController getGc() {
        return gc;
    }


    @Override
    public boolean isActive() {
        return active;
    }

    public Circle getHitArea() {
        return hitArea;
    }

    public float getScale() {
        return scale;
    }

    public int getPower() {
        return power;
    }

    public PowerBoostType getBoostType() {
        return boostType;
    }
}

