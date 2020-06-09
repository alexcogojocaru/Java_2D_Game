package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class LeftWallTile extends Tile {
    public LeftWallTile(int id) {
        super(Assets.leftWall, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
