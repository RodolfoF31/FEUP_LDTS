package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.elements.Weapon;

public class WeaponViewer implements ElementViewer<Weapon> {
    @Override
    public void draw(Weapon weapon, GUI gui) {
        gui.drawWeapon(weapon.getPosition(), weapon.getSide());
    }
}
