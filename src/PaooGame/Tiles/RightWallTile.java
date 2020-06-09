package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class RightWallTile extends Tile {
    public RightWallTile(int id) {
        super(Assets.rightWall, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
