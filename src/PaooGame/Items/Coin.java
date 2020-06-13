package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class Coin
 */
public class Coin extends Item {
    private Animation animation;

    /*! \fn Coin(RefLinks refLink, float x, float y)
        \brief Constructorul clasei
     */
    public Coin(RefLinks refLink, float x, float y) {
        super(refLink, x, y, ITEM_WIDTH, ITEM_HEIGHT);
        animation = new Animation(500, Assets.coinAnimation);
    }

    /*! \fn public void Update()
     */
    @Override
    public void Update() {
        animation.Update();
    }

    /*! \fn public void Draw(Graphics g)
     */
    @Override
    public void Draw(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), (int)x, (int)y, width, height, null);
//        g.setColor(Color.BLUE);
//        g.drawRect((int)(normalBounds.x + x), (int)(normalBounds.y + y), normalBounds.width, normalBounds.height);
    }
}
