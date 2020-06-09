package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class ChestOpenTile extends Tile {
    public ChestOpenTile(int id) {
        super(Assets.chestOpen, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
