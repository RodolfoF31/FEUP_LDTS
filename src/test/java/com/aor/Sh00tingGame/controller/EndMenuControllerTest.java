package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.menu.EndMenuController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.game.arena.LoaderArenaBuilder;
import com.aor.Sh00tingGame.model.menu.EndMenu;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.states.GameState;
import com.aor.Sh00tingGame.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EndMenuControllerTest {
    private GUI gui;
    private EndMenu endMenu;

    @BeforeEach
    void setUp() {
        this.gui = mock(LanternaGUI.class);
        this.endMenu = mock(EndMenu.class);

        when(endMenu.getNumberEntries()).thenReturn(2);
        when(endMenu.getEntry(0)).thenReturn("Menu");
        when(endMenu.getEntry(1)).thenReturn("Quit");
        when(endMenu.isSelectedMenu()).thenReturn(true);
        when(endMenu.isSelectedQuit()).thenReturn(false);
    }

    @Test
    void testStep_menuSelected() throws IOException {
        EndMenuController controller = new EndMenuController(endMenu);
        Game game = mock(Game.class);

        controller.step(game, GUI.ACTION.SELECT, 0);

        verify(endMenu, times(1)).isSelectedMenu();
        verify(game, times(1)).setDeath(0);
        verify(game, times(1)).setLevel(1);

    }

    @Test
    void testStep_quitSelected() throws IOException {
        EndMenuController controller = new EndMenuController(endMenu);
        Game game = mock(Game.class);

        when(endMenu.isSelectedMenu()).thenReturn(false);
        when(endMenu.isSelectedQuit()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 0);

        verify(endMenu, times(1)).isSelectedQuit();
        verify(game, times(1)).setState(null);
    }

    @Test
    void testStep_shootUp() throws IOException {
        EndMenuController controller = new EndMenuController(endMenu);
        Game game = mock(Game.class);

        controller.step(game, GUI.ACTION.SHOOTUP, 0);

        verify(endMenu, times(1)).previousEntry();
    }

    @Test
    void testStep_shootDown() throws IOException {
        EndMenuController controller = new EndMenuController(endMenu);
        Game game = mock(Game.class);

        controller.step(game, GUI.ACTION.SHOOTDOWN, 0);

        verify(endMenu, times(1)).nextEntry();
    }
}

