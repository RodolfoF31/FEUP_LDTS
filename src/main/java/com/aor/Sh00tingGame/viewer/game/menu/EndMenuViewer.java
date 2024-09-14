package com.aor.Sh00tingGame.viewer.game.menu;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.EndMenu;
import com.aor.Sh00tingGame.viewer.Viewer;

public class EndMenuViewer extends Viewer<EndMenu> {

    public EndMenuViewer(EndMenu endMenu){
        super(endMenu);
    }
    @Override
    public void drawElements(GUI gui) {
        int death = getModel().getDeath();
        if(death == 0){
            gui.drawText(new Position(28, 5),    "You have Killed ALL the Enemies!", "#FF0000");
            gui.drawText(new Position(28, 6),    "  Thanks for Playing our Game!", "#FF0000");}

        else gui.drawText(new Position(28, 5),   "                  You DIED                    ", "#FF0000");
        gui.drawText(new Position(28,7),         "Wanna QUIT or go back to the MENU and replay?", "#FF0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(26, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}

