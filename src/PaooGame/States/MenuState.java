package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;
import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    private Font font;
    private int currentOption;
    private Color[] colors;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        font = new Font("arial", Font.BOLD, 50);
        currentOption = 0;
        colors = new Color[3];
        colors[0] = Color.RED;
        colors[1] = Color.WHITE;
        colors[2] = Color.WHITE;
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        if (refLink.GetKeyManager().up) {
            colors[currentOption--] = Color.WHITE;
            if (currentOption < 0) {
                currentOption = 0;
            }
            colors[currentOption] = Color.RED;
            System.out.println("W");
        }

        if (refLink.GetKeyManager().down) {
            colors[currentOption++] = Color.WHITE;
            if (currentOption > 2) {
                currentOption = 2;
            }
            colors[currentOption] = Color.RED;
            System.out.println("S");
        }

        if (refLink.GetKeyManager().enter && currentOption == 0) {
            State.SetState(Game.playState);
        }

        if (refLink.GetKeyManager().enter && currentOption == 1) {
            int[] data = Game.databaseManager.Select(1);
            if (data != null) {
                PlayState.x = data[0];
                PlayState.y = data[1];
                PlayState.level = data[2];
            }
        }

        if (refLink.GetKeyManager().enter && currentOption == 2) {
            System.exit(0);
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(refLink.GetMouseManager().getMouseX(), refLink.GetMouseManager().getMouseY(), 8, 8);

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("DUNGEON HERO", refLink.GetWidth() / 2 - "DUNGEON HERO".length() * 16, 100);
        g.setColor(colors[0]);
        g.drawString("START", refLink.GetWidth() / 2 - "START".length() * 16, 200);
        g.setColor(colors[1]);
        g.drawString("LOAD", refLink.GetWidth() / 2 - "LOAD".length() * 16, 300);
        g.setColor(colors[2]);
        g.drawString("EXIT", refLink.GetWidth() / 2 - "EXIT".length() * 16, 400);
    }
}
