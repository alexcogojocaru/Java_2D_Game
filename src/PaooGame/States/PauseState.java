package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class PauseState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class PauseState extends State
{
    private int currentOption;
    private Color[] colors;

    /*! \fn public PauseState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PauseState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
        super(refLink);
        currentOption = 0;
        colors = new Color[3];
        colors[0] = Color.RED;
        colors[1] = Color.WHITE;
        colors[2] = Color.WHITE;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {
        if (refLink.GetKeyManager().escape) {
            State.SetState(Game.playState);
        }

        if (refLink.GetKeyManager().up) {
            colors[currentOption--] = Color.WHITE;
            if (currentOption < 0) {
                currentOption = 0;
            }
            colors[currentOption] = Color.RED;
        }

        if (refLink.GetKeyManager().down) {
            colors[currentOption++] = Color.WHITE;
            if (currentOption > 2) {
                currentOption = 2;
            }
            colors[currentOption] = Color.RED;
        }

        if (refLink.GetKeyManager().enter && currentOption == 0) {
            State.SetState(Game.playState);
        }

        if (refLink.GetKeyManager().enter && currentOption == 1) {
            int x = (int)Game.playState.getHero().GetX();
            int y = (int)Game.playState.getHero().GetY();
            int level = Game.playState.isFirstLevel() ? 1 : 2;

            Game.databaseManager.Update(1, x, y, level);
        }

        if (refLink.GetKeyManager().enter && currentOption == 2) {
            System.exit(0);
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.setColor(colors[0]);
        g.drawString("RESUME", refLink.GetWidth() / 2 - "START".length() * 16, 200);
        g.setColor(colors[1]);
        g.drawString("SAVE", refLink.GetWidth() / 2 - "LOAD".length() * 16, 300);
        g.setColor(colors[2]);
        g.drawString("EXIT", refLink.GetWidth() / 2 - "EXIT".length() * 16, 400);
    }
}
