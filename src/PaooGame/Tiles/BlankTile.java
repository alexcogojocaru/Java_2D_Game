package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class BlankTile extends Tile {
    public BlankTile(int id) {
        super(Assets.blankTile, id);
    }

    @Override
    public boolean IsSolid() {
        return false;
    }
}
