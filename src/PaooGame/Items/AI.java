package PaooGame.Items;

import java.util.ArrayList;

public class AI {
    private Hero hero;
    private ArrayList<Monster> monsters;

    public AI(Hero hero, ArrayList<Monster> monsters) {
        this.hero = hero;
        this.monsters = monsters;

    }

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
