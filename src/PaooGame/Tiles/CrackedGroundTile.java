package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class CrackedGroundTile extends Tile {
    public CrackedGroundTile(int id) {
        super(Assets.crackedGroundTile, id);
    }

    @Override
    public boolean IsSolid() {
        return false;
    }
}
