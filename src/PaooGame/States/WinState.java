package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class WinState extends State
    \brief state pentru finalul jocului
 */
public class WinState extends State {
    /*! \fn WinState(RefLinks refLink)
     */
    public WinState(RefLinks refLink) {
        super(refLink);
    }

    /*! \fn void Update()
     */
    @Override
    public void Update() {
        if (refLink.GetKeyManager().enter) {
            State.SetState(Game.menuState);
        }
    }

    /*! \fn void Draw(Graphics g)
     */
    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(refLink.GetMouseManager().getMouseX(), refLink.GetMouseManager().getMouseY(), 8, 8);

        g.setFont(new Font("arial", Font.BOLD, 50));
        g.setColor(Color.RED);
        g.drawString("YOU WON" +
                "", refLink.GetWidth() / 2 - "YOU DIED".length() * 16, 100);

        g.drawString("GO TO MAIN MENU", refLink.GetWidth() / 2 - "GO TO MAIN MENU".length() * 16, 300);

    }
}
