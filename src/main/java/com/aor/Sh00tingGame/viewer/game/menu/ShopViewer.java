package com.aor.Sh00tingGame.viewer.game.menu;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.Shop;
import com.aor.Sh00tingGame.viewer.Viewer;

public class ShopViewer extends Viewer<Shop> {
    public ShopViewer(Shop model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(38, 5), "WEAP0N SH0P", "#FF0000");

        gui.drawText(new Position(38, 7), " Money: " + getModel().getHero().getMoney() + "$", "#FFFF00");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (i == getModel().getNumberEntries() - 1) {
                gui.drawText(
                        new Position(34, 10 + i + 2),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
                break;
            }
            if (!getModel().getOptions().get(i).getAgain()) {
                gui.drawText(new Position(34, 10 + i), "Already Bought",getModel().isSelected(i) ? "#FF0000" : "#FFC0CB");
            }
            else
                gui.drawText(
                    new Position(34, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");

            if (getModel().getHero().getMoney() < getModel().getOptions().get(i).getPrice()) {
                if (getModel().getOptions().get(i).getAgain())
                    gui.drawText(new Position(55, 10 + i), "Not enough Money", "#3333FF");
            }
        }
    }
}
