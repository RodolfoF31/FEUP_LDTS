package com.aor.Sh00tingGame.viewer;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.viewer.game.menu.MenuViewer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class MenuViewerTest {
        @Test
        void testDrawElements() {
            GUI gui = mock(LanternaGUI.class);

            Menu menu = mock(Menu.class);
            when(menu.getNumberEntries()).thenReturn(3);
            when(menu.getEntry(0)).thenReturn("Play");
            when(menu.getEntry(1)).thenReturn("Controls");
            when(menu.getEntry(2)).thenReturn("Quit");
            when(menu.isSelected(0)).thenReturn(true);
            when(menu.isSelected(1)).thenReturn(false);
            when(menu.isSelected(2)).thenReturn(false);
            MenuViewer viewer = new MenuViewer(menu);

            viewer.drawElements(gui);

            verify(gui, times(1)).drawText(new Position(40, 5), "SH00TING GAME", "#FF0000");
            verify(gui, times(1)).drawText(new Position(42, 9), "Play", "#FF0000");
            verify(gui, times(1)).drawText(new Position(42, 10), "Controls", "#FFFFFF");
            verify(gui, times(1)).drawText(new Position(42, 11), "Quit", "#FFFFFF");
        }
    }
