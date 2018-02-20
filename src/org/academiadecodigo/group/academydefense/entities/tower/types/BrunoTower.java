package org.academiadecodigo.group.academydefense.entities.tower.types;

import org.academiadecodigo.group.academydefense.entities.tower.Tower;
import org.academiadecodigo.group.academydefense.grid.tiles.TiledGrid;

public class BrunoTower extends Tower {

    public BrunoTower(TiledGrid grid, int x, int y) {
        super(grid, x, y, 1, 1, 100);
    }
}
