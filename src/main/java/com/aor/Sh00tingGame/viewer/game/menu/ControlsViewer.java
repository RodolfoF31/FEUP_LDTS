package com.aor.Sh00tingGame.viewer.game.menu;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.Controls;
import com.aor.Sh00tingGame.viewer.Viewer;

public class ControlsViewer extends Viewer<Controls> {
    public ControlsViewer(Controls options) {
        super(options);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(30,5), "in-MENU:", "#5D3FD3");
        int i;
        for (i = 0; i < getModel().getMenuNumberEntries(); i++) {
            gui.drawText(
                    new Position(30,  5+ i+1),
                    getModel().getMenuEntry(i),
                    "#FFFFFF");
        }
        int curpos = 5+ getModel().getMenuNumberEntries()+3;
        gui.drawText(new Position(30, curpos), "in-GAME:", "#5D3FD3");
        for (i = 0; i < getModel().getGameNumberEntries(); i++) {
            gui.drawText(
                    new Position(30,  curpos+i+1),
                    getModel().getGameEntry(i),
                    "#FFFFFF");
        }
        curpos+=i;
        gui.drawText(new Position(20, curpos+2), getModel().getOnlyOption(), "#FF0000");
    }
}


