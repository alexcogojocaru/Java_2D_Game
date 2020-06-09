package PaooGame.Items;

import PaooGame.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HealthBar {
    private static HealthBar healthBarInstance = null;

    private BufferedImage[] healthBar;
    private Hero hero;

    private HealthBar(Hero hero) {
        this.hero = hero;
        healthBar = new BufferedImage[3];

        healthBar[0] = Assets.heartFull;
        healthBar[1] = Assets.heartFull;
        healthBar[2] = Assets.heartFull;
    }

    public static HealthBar getInstance(Hero hero) {
        if (healthBarInstance == null) {
            healthBarInstance = new HealthBar(hero);
        }
        return healthBarInstance;
    }

    public void Update(boolean hit) {
        if (hit) {
            hero.TakeDamage(1);
        }

        int health = hero.GetLife();
        if (health > 400 && health <= 500)
            healthBar[2] = Assets.heartHalf;

        if (health > 300 && health <= 400)
            healthBar[2] = Assets.heartEmpty;

        if (health > 200 && health < 300)
            healthBar[1] = Assets.heartHalf;

        if (health > 100 && health <= 200)
            healthBar[1] = Assets.heartEmpty;

        if (health > 0 && health <= 100)
            healthBar[0] = Assets.heartHalf;

        if (health == 0)
            healthBar[0] = Assets.heartEmpty;
    }

    public void Draw(Graphics g) {
        g.drawImage(healthBar[0], 0, 0, 32, 32, null);
        g.drawImage(healthBar[1], 32, 0, 32, 32,null);
        g.drawImage(healthBar[2], 64, 0, 32, 32,null);
    }
}
