package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class Monster extends Character {
    private Animation animation;
    private boolean isAlive;

    public Monster(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        normalBounds.x = 16;
        normalBounds.y = 16;
        normalBounds.width = 16;
        normalBounds.height = 32;

        animation = new Animation(200, Assets.zombieAnimation);

        life = 100;
        isAlive = true;
    }

    public void skullCollision(SkullBall skullBall) {
        if (getCollisionBounds().intersects(skullBall.getCollisionBounds())) {
            TakeDamage(10);
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void Update() {
        animation.Update();
        Move();

        skullCollision(Hero.skullBall);

        if (life <= 0 && isAlive) {
            isAlive = false;
            Hero.points += 50;
        }
    }

    @Override
    public void Draw(Graphics g) {
        if (isAlive) {
            if (facingRight) {
                g.drawImage(animation.getCurrentFrame(), (int)x, (int)y, width, height, null);
            } else {
                g.drawImage(animation.getCurrentFrame(), (int)x + DEFAULT_CREATURE_WIDTH, (int)y, -width, height, null);
            }

            g.setColor(Color.GREEN);
            g.drawRect((int)x, (int)y + BIT_SIZE, width, height - BIT_SIZE);
        }
    }
}
