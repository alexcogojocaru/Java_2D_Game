package PaooGame.Items;

import java.util.ArrayList;
/*! \class AI
    \brief clasa pentru miscarea automata a inamicilor catre erou

*/
public class AI {
    private Hero hero;
    private ArrayList<Monster> monsters;

    /*! \fn AI(Hero hero, ArrayList<Monster> monsters)
        \brief Constructorul clasei AI

        \param hero Referinta catre erou
        \param monsters Lista de referinte catre monstri
     */
    public AI(Hero hero, ArrayList<Monster> monsters) {
        this.hero = hero;
        this.monsters = monsters;

    }

    /*! \fn public void MoveToHero()
        \brief Functie pentru miscare automata
     */
    public void MoveToHero() {
        for (Monster monster : monsters) {
            if (hero.GetX() < monster.GetX()) {
                monster.xMove = -Character.MONSTER_SPEED;
                monster.facingRight = false;
            } else {
                monster.xMove = Character.MONSTER_SPEED;
                monster.facingRight = true;
            }

            if (hero.GetY() < monster.GetY()) {
                monster.yMove = -Character.MONSTER_SPEED;
            } else {
                monster.yMove = Character.MONSTER_SPEED;
            }
        }
    }
}
