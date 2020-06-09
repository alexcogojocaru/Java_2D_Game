package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class DownWallTile extends Tile {
    public DownWallTile(int idd) {
        super(Assets.downWall, idd);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
