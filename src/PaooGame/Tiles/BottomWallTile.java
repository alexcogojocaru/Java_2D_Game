package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class BottomWallTile extends Tile {
    public BottomWallTile(int id) {
        super(Assets.bottomWall, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
