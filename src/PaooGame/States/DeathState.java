package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class DeathState extends State
{
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public DeathState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
        if (refLink.GetKeyManager().enter) {
            State.SetState(Game.menuState);
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(refLink.GetMouseManager().getMouseX(), refLink.GetMouseManager().getMouseY(), 8, 8);

        g.setFont(new Font("arial", Font.BOLD, 50));
        g.setColor(Color.RED);
        g.drawString("YOU DIED", refLink.GetWidth() / 2 - "YOU DIED".length() * 16, 100);

        g.drawString("GO TO MAIN MENU", refLink.GetWidth() / 2 - "GO TO MAIN MENU".length() * 16, 300);
    }
}
