package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.elements.Shoot;

public class ShootViewer implements ElementViewer<Shoot> {
    @Override
    public void draw(Shoot shoot, GUI gui) {
        gui.drawShoot(shoot.getPosition());
    }
}
