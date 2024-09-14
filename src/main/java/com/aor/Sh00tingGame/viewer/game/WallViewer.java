package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
