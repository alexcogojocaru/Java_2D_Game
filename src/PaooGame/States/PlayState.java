package PaooGame.States;

import PaooGame.DatabaseManager;
import PaooGame.Game;
import PaooGame.Items.*;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    public static boolean isLoaded = false;
    public static int x = 0;
    public static int y = 0;
    public static int level = 1;

    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private MapFactory mapFactory;    /*!< Referinta catre harta curenta.*/
    private Map map;

    public static ArrayList<Monster> monsters;
    public static ArrayList<Coin> coins;

    private boolean firstLevel;

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
            ///Construieste eroul
        if (isLoaded) {
            hero = new Hero(refLink, x, y);
        } else {
            hero = new Hero(refLink,300, 100);
        }

        monsters = new ArrayList<>();

        coins = new ArrayList<>();
        coins.add(new Coin(refLink, 200, 200));
        coins.add(new Coin(refLink, 600, 400));

        mapFactory = new MapFactory(refLink);
        map = mapFactory.getMap(level, hero);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        firstLevel = true;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();

        for (Coin coin : coins) {
            coin.Update();
        }

        if (hero.GetLife() <= 0) {
            State.SetState(Game.deathState);
        }

        if (refLink.GetKeyManager().escape) {
            State.SetState(Game.pauseState);
        }

        if (map.getLevel() == 2 && firstLevel) {
            map = mapFactory.getMap(2, hero);
            firstLevel = false;
            refLink.SetMap(map);
        }

        if (map.getLevel() == 4) {
            State.SetState(Game.winState);
        }
    }

    public boolean isFirstLevel() {
        return firstLevel;
    }

    public Hero getHero() {
        return hero;
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

        for (Coin coin : coins) {
            coin.Draw(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Score: " + Hero.points, 0, 50);
    }
}
