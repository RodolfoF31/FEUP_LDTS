package com.aor.Sh00tingGame.viewer;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.EndMenu;
import com.aor.Sh00tingGame.viewer.game.menu.EndMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class EndMenuViewerTest {
    private GUI gui;
    private EndMenu endMenu;

    @BeforeEach
    void setUp(){
        gui = mock(LanternaGUI.class);
        endMenu = mock(EndMenu.class);
        when(endMenu.getNumberEntries()).thenReturn(2);
        when(endMenu.getEntry(0)).thenReturn("Quit");
        when(endMenu.getEntry(1)).thenReturn("Menu");
    }

    @Test
    void testDrawElements_death() {

        when(endMenu.getDeath()).thenReturn(1);

        when(endMenu.isSelected(0)).thenReturn(false);
        when(endMenu.isSelected(1)).thenReturn(true);
        EndMenuViewer viewer = new EndMenuViewer(endMenu);

        viewer.drawElements(gui);

        verify(gui, times(1)).drawText(new Position(28, 5), "                  You DIED                    ", "#FF0000");
        verify(gui, times(1)).drawText(new Position(28, 7), "Wanna QUIT or go back to the MENU and replay?", "#FF0000");
        verify(gui, times(1)).drawText(new Position(26, 10), "Quit", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(26, 11), "Menu", "#FF0000");
    }

    @Test
    void testDrawElements_win() {
        when(endMenu.getDeath()).thenReturn(0);

        when(endMenu.isSelected(0)).thenReturn(true);
        when(endMenu.isSelected(1)).thenReturn(false);
        EndMenuViewer viewer = new EndMenuViewer(endMenu);

        viewer.drawElements(gui);

        verify(gui, times(1)).drawText(new Position(28, 5), "You have Killed ALL the Enemies!", "#FF0000");
        verify(gui, times(1)).drawText(new Position(28, 6), "  Thanks for Playing our Game!", "#FF0000");
        verify(gui, times(1)).drawText(new Position(26, 10), "Quit", "#FF0000");
        verify(gui, times(1)).drawText(new Position(26, 11), "Menu", "#FFFFFF");
    }

}
