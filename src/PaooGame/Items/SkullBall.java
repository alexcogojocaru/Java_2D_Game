package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class SkullBall
 */
public class SkullBall extends Item {
    private Hero hero;
    private BufferedImage image;
    private boolean rangedAttack;
    private boolean facingRight;

    private final int RANGE = 500;

    /*! \fn SkullBall(RefLinks refLink, Hero hero)
     */
    public SkullBall(RefLinks refLink, Hero hero) {
        super(refLink, 0, 0, ITEM_WIDTH, ITEM_HEIGHT);
        this.hero = hero;
        this.image = Assets.skull;
        rangedAttack = false;
        facingRight = true;
    }

    /*! \fn public void Update()
     */
    @Override
    public void Update() {
        if (refLink.GetMouseManager().isLeftPressed()) {
            x = hero.GetX();
            y = hero.GetY();
            rangedAttack = true;

            facingRight = !(refLink.GetMouseManager().getMouseX() < x);
        }
    }

    /*! public void Draw(Graphics g)
     */
    @Override
    public void Draw(Graphics g) {
        if (rangedAttack) {
            g.drawImage(image, (int) x, (int) y, 32, 32, null);

            if (facingRight) {
                x += 3.0f;
            } else {
                x -= 3.0f;
            }
        }
    }
}
