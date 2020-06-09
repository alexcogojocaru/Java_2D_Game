package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Potion extends Item {
    private BufferedImage image;

    public Potion(RefLinks refLink, float x, float y) {
        super(refLink, x, y, ITEM_WIDTH, ITEM_HEIGHT);
        image = Assets.potion;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
        g.setColor(Color.BLUE);
        g.drawRect((int)(normalBounds.x + x), (int)(normalBounds.y + y), normalBounds.width, normalBounds.height);
    }
}
