package com.aor.Sh00tingGame.viewer;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.menu.Controls;
import com.aor.Sh00tingGame.viewer.game.menu.ControlsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControlsViewerTest {
    private GUI gui;
    private Controls controls;

    @BeforeEach
    void setUp(){
        this.gui = mock(LanternaGUI.class);
        this.controls = mock(Controls.class);

        when(controls.getMenuNumberEntries()).thenReturn(2);
        when(controls.getMenuEntry(0)).thenReturn("Arrow Keys\t\t\tMove Up and Down");
        when(controls.getMenuEntry(1)).thenReturn("ENTER\t\t\t\t\tSelect Next Step");
        when(controls.getOnlyOption()).thenReturn("EXIT");

        when(controls.getGameNumberEntries()).thenReturn(8);
        when(controls.getGameEntry(0)).thenReturn("W\t\t\t\t\t\tMove Up");
        when(controls.getGameEntry(1)).thenReturn("A\t\t\t\t\t\tMove Left");
        when(controls.getGameEntry(2)).thenReturn("S\t\t\t\t\t\tMove Down");
        when(controls.getGameEntry(3)).thenReturn("D\t\t\t\t\t\tMove Right");
        when(controls.getGameEntry(4)).thenReturn("Arrow Keys\t\t\tShoot in the Key's Direction");
        when(controls.getGameEntry(5)).thenReturn("B\t\t\t\t\t\tGo to Weapon Store");
        when(controls.getGameEntry(6)).thenReturn("1-4\t\t\t\t\tSelect Weapon");
        when(controls.getGameEntry(7)).thenReturn("ESC\t\t\t\t\tGo to Menu");
    }
   @Test
    void testDrawElements() {
        ControlsViewer viewer = new ControlsViewer(controls);

        viewer.drawElements(gui);

        verify(gui, times(1)).drawText(new Position(30, 5), "in-MENU:", "#5D3FD3");
        verify(gui, times(1)).drawText(new Position(30, 6), "Arrow Keys\t\t\tMove Up and Down", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 7), "ENTER\t\t\t\t\tSelect Next Step", "#FFFFFF");

        verify(gui, times(1)).drawText(new Position(30, 10), "in-GAME:", "#5D3FD3");
        verify(gui, times(1)).drawText(new Position(30, 11), "W\t\t\t\t\t\tMove Up", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 12), "A\t\t\t\t\t\tMove Left", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 13), "S\t\t\t\t\t\tMove Down", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 14), "D\t\t\t\t\t\tMove Right", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 15), "Arrow Keys\t\t\tShoot in the Key's Direction", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 16), "B\t\t\t\t\t\tGo to Weapon Store", "#FFFFFF");
        verify(gui, times(1)).drawText(new Position(30, 17), "1-4\t\t\t\t\tSelect Weapon", "#FFFFFF");
       verify(gui, times(1)).drawText(new Position(30, 18), "ESC\t\t\t\t\tGo to Menu", "#FFFFFF");
       verify(gui, times(1)).drawText(new Position(20, 20), "EXIT", "#FF0000");
    }
}
