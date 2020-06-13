package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;


/*! \class Monster
    \brief Descrierea unui character de tip monstru
 */
public class Monster extends Character {
    private Animation animation;
    private boolean isAlive;
    private boolean lock;

    /*! \fn Monster(RefLinks refLink, float x, float y, int width, int height, BufferedImage[] images)
        \brief Constructorul clasei Monster

        \param refLink variabila ce contine o serie de referinte
        \param x coordonata x pe axa
        \param y coordonata y pe axa
        \param width latimea
        \param height inaltimea
        \param images spritesheet-urile pentru animatie
     */
    public Monster(RefLinks refLink, float x, float y, int width, int height, BufferedImage[] images) {
        super(refLink, x, y, width, height);

        normalBounds.x = 16;
        normalBounds.y = 16;
        normalBounds.width = 16;
        normalBounds.height = 32;

        animation = new Animation(200, images);

        life = 100;
        isAlive = true;
        lock = true;
    }

    /*! \fn public void skullCollision(SkullBall skullBall)
        \brief implementeaza coliziunea monstrului cu bila lansata de erou

        \param skullBall referinta catre bila lansata de erou
     */
    public void skullCollision(SkullBall skullBall) {
        if (getCollisionBounds().intersects(skullBall.getCollisionBounds())) {
            TakeDamage(5);
        }
    }


    /*! \fn public boolean isAlive()
        \brief returneaza true daca monstrul nu mai are viata
     */
    public boolean isAlive() {
        if (lock && !isAlive) {
            lock = false;
            return true;
        }
        return false;
    }

    /*! \fn public void Update()
     */
    @Override
    public void Update() {
        animation.Update();
        Move();

        skullCollision(Hero.skullBall);

        if (life <= 0 && isAlive) {
            isAlive = false;
            Hero.points += 50;
        }

        if (!isAlive) {
            x = 0;
            y = 0;
        }
    }

    /*! \fn public void Draw(Graphics g)
     */
    @Override
    public void Draw(Graphics g) {
        if (isAlive) {
            if (facingRight) {
                g.drawImage(animation.getCurrentFrame(), (int)x, (int)y, width, height, null);
            } else {
                g.drawImage(animation.getCurrentFrame(), (int)x + DEFAULT_CREATURE_WIDTH, (int)y, -width, height, null);
            }

//            g.setColor(Color.GREEN);
//            g.drawRect((int)x, (int)y + BIT_SIZE, width, height - BIT_SIZE);
        }
    }
}
