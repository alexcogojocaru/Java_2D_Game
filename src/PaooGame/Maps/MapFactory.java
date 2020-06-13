package PaooGame.Maps;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;

/*! \class MapFactory
    \brief clasa ce implementeaza design pattern-ul Factory pentru a construi harta
 */
public class MapFactory {
    private RefLinks refLink;

    /*! \fn MapFactory(RefLinks refLink)
     */
    public MapFactory(RefLinks refLink) {
        this.refLink = refLink;
    }

    /*! \fn public Map getMap(int option, Hero hero)
        \brief returneaza harta in functie de optiune
        \brief option = 1 -> harta 1
        \brief option != 1 -> harta 2
     */
    public Map getMap(int option, Hero hero) {
        if (option == 1) {
            return new FirstMap(refLink, hero);
        }
        return new SecondMap(refLink, hero);
    }
}
