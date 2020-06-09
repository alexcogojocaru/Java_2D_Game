package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class GroundTile extends Tile {
    public GroundTile(int id) {
        super(Assets.groundTile, id);
    }

    @Override
    public boolean IsSolid() {
        return false;
    }
}
