package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    public static ArrayList<Monster> monsters;
    public static ArrayList<Coin> coins;
    public static ArrayList<Potion> potions;
    private AI ai;

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        hero = new Hero(refLink,300, 100);
        monsters = new ArrayList<>();
        coins = new ArrayList<>();
        potions = new ArrayList<>();

        coins.add(new Coin(refLink, 200, 200));
        coins.add(new Coin(refLink, 250, 200));

        monsters.add(new Monster(refLink, 150, 100));
        monsters.add(new Monster(refLink, 600, 100));
        monsters.add(new Monster(refLink, 600, 300));

        potions.add(new Potion(refLink, 100, 100));

        ai = new AI(hero, monsters);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        for (Monster monster : monsters) {
            monster.Update();
//            hero.setMonster(monster);
        }
//        hero.setCoins(coins);
        ai.MoveToHero();

        for (Coin coin : coins) {
            coin.Update();
        }

        for (Potion potion : potions) {
            potion.Update();
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        hero.Draw(g);
        for (Monster monster : monsters) {
            monster.Draw(g);
        }

        for (Coin coin : coins) {
            coin.Draw(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Score: " + Hero.points, 0, 50);

//        for (Potion potion : potions) {
//            potion.Draw(g);
//        }

//        g.setColor(Color.RED);
//        g.fillRect(refLink.GetMouseManager().getMouseX(), refLink.GetMouseManager().getMouseY(), 8, 8);
//        g.drawImage(Assets.potion, 40, 40, 32, 32,null);
    }
}
