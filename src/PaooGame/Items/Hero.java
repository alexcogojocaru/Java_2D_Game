package PaooGame.Items;

import java.awt.*;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.PlayState;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
//    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private HealthBar healthBar;
    private Animation animation;
    public static SkullBall skullBall;
    public static int points = 0;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului
//        image = Assets.hero;
        healthBar = HealthBar.getInstance(this);
        skullBall = new SkullBall(refLink, this);

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 0;
        normalBounds.y = BIT_SIZE;
        normalBounds.width = Character.DEFAULT_CREATURE_WIDTH;
        normalBounds.height = Character.DEFAULT_CREATURE_HEIGHT - BIT_SIZE;

        animation = new Animation(200, Assets.heroAnimation);
    }

    /*! \fn public void Update()
                    \brief Actualizeaza pozitia si imaginea eroului.
                 */
    @Override
    public void Update()
    {
        animation.Update();
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        skullBall.Update();
        Move();

        for (Monster monster : Map.monsters) {
            healthBar.Update(MonsterCollision(monster));
        }

        for (Coin coin : PlayState.coins) {
            if (getCollisionBounds().intersects(coin.getCollisionBounds())) {
                PlayState.coins.remove(coin);
                points += 10;
                break;
            }
        }
    }

    /*! \fn public boolean MonsterCollision(Monster monster)
        \brief Testeaza coliziunea cu monster-ul
     */
    public boolean MonsterCollision(Monster monster) {
        return getCollisionBounds().intersects(monster.getCollisionBounds());
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
            facingRight = false;
        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
            facingRight = true;
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafic in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        if (facingRight) {
            g.drawImage(animation.getCurrentFrame(), (int)x, (int)y, width, height, null);
        } else {
            g.drawImage(animation.getCurrentFrame(), (int)x + DEFAULT_CREATURE_WIDTH, (int)y, -width, height, null);
        }
        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        healthBar.Draw(g);
        skullBall.Draw(g);

//        g.setColor(Color.RED);
//        g.drawRect((int)(normalBounds.x + x), (int)(normalBounds.y + y), normalBounds.width, normalBounds.height);
    }
}
