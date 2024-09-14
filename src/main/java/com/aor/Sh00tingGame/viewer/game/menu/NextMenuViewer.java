package com.aor.Sh00tingGame.viewer.game.menu;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.NextMenu;
import com.aor.Sh00tingGame.viewer.Viewer;

public class NextMenuViewer extends Viewer<NextMenu> {

    public NextMenuViewer(NextMenu nextMenu){
        super(nextMenu);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(28, 5), "You have Killed all the Enemies in this phase!", "#FF0000");
        gui.drawText(new Position(28, 6), "           Do YOU wish to Continue", "#FF0000");
        gui.drawText(new Position(28,7),  "             to the Next Level?", "#FF0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(25, 12 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}

