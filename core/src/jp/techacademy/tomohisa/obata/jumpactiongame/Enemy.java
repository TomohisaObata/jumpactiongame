package jp.techacademy.tomohisa.obata.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

/**
 * Created by tomohisa on 2017/01/14.
 */

public class Enemy extends GameObject {

    // 横幅、高さ
    public static final float ENEMY_WIDTH = 0.8f;
    public static final float ENEMY_HEIGHT = 0.8f;

    //速度
    public static final float ENEMY_MOVE_VELOCITY_X = 2.0f;
    public static final float ENEMY_MOVE_VELOCITY_Y = 2.0f;

    //方向
    int mDirectionX = 1;
    int mDirectionY = 1;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        Random mRandom = new Random();
        if (mRandom.nextFloat() > 0.5f) {
            this.mDirectionX = -1;
        }
        velocity.x = mDirectionX * ENEMY_MOVE_VELOCITY_X;

        if (mRandom.nextFloat() > 0.5f) {
            this.mDirectionY = -1;
        }
        velocity.y = mDirectionY * ENEMY_MOVE_VELOCITY_Y;
    }

    public void update (float delta) {

        // 敵の位置を計算する
        velocity.y = mDirectionY * ENEMY_MOVE_VELOCITY_Y;
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);

        if (getX() < ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(ENEMY_WIDTH / 2);
        }
        if (getX() > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2);
        }
    }

    public void setDirection(){
        this.mDirectionY = -1 * this.mDirectionY;
    }
}
