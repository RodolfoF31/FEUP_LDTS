package com.aor.Sh00tingGame.viewer;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.NextMenu;
import com.aor.Sh00tingGame.viewer.game.menu.NextMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NextMenuViewerTest {

    private GUI gui;
    private NextMenu nextMenu;

    @BeforeEach
    void setUp(){
        gui = mock(LanternaGUI.class);
        nextMenu = mock(NextMenu.class);
        when(nextMenu.getNumberEntries()).thenReturn(2);
        when(nextMenu.getEntry(0)).thenReturn("YES");
        when(nextMenu.getEntry(1)).thenReturn("NO");
        when(nextMenu.isSelected(0)).thenReturn(true);
        when(nextMenu.isSelected(1)).thenReturn(false);
    }

    @Test
    void drawElements(){
        NextMenuViewer viewer = new NextMenuViewer(nextMenu);
        viewer.drawElements(gui);

        verify(gui, times(1)).drawText(new Position(28, 5), "You have Killed all the Enemies in this phase!", "#FF0000");
        verify(gui, times(1)).drawText(new Position(28, 6), "           Do YOU wish to Continue", "#FF0000");
        verify(gui, times(1)).drawText(new Position(28, 7), "             to the Next Level?", "#FF0000");
        verify(gui, times(1)).drawText(new Position(25, 12), "YES", "#FF0000");
        verify(gui, times(1)).drawText(new Position(25, 13), "NO", "#FFFFFF");
    }
}
