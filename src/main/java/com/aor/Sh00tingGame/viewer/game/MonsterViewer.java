package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition(), monster.getHealth());
    }
}
