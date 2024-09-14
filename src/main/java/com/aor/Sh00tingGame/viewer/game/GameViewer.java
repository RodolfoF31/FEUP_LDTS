package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Element;
import com.aor.Sh00tingGame.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getShoot(), new ShootViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
        drawElement(gui, getModel().getWeapon(), new WeaponViewer());
        drawElements(gui,getModel().getCoin(), new CoinViewer());

        gui.drawText(new Position(0, 0), "Health: " + getModel().getHero().getEnergy(), "#FFD700");
        gui.drawText(new Position(0, 1), "Money: " + getModel().getHero().getMoney()+"$", "#FFFF00");
        gui.drawText(new Position(0, 2), "Weapon: " + getModel().getHero().getWeaponUsed(),"#FFC0CB");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
