package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.Items.*;
import PaooGame.Items.Character;
import PaooGame.RefLinks;

import java.util.ArrayList;

/*! \class FirstMap
 */
public class FirstMap extends Map {
    /*! \fn FirstMap(RefLinks refLink, Hero hero)
     */
    public FirstMap(RefLinks refLink, Hero hero) {
        super(refLink, hero);
        monsters = new ArrayList<>();
        monsters.add(new Monster(refLink, 150, 100, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 100, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 300, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 300, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 300, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 300, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));
        monsters.add(new Monster(refLink, 600, 300, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, Assets.zombieAnimation));

        ai = new AI(hero, monsters);
        numberOfEnemies = monsters.size();
        level = 1;
    }

    /*! \fn protected int GenerateMap(int x, int y)
        \brief genereaza harta specifica nivelului
     */
    @Override
    protected int GenerateMap(int x, int y) {
        final int map[][] = {
                {10, 10, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 10, 10, 10},
                {10, 10, 3, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 10, 10},
                {10, 10, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 10, 10, 10}
        };

        return map[x][y];
    }
}
