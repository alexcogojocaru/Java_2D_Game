package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class HeartFullTile extends Tile {
    public HeartFullTile(int id) {
        super(Assets.heartFull, id);
    }

    @Override
    public boolean IsSolid() {
        return false;
    }
}
