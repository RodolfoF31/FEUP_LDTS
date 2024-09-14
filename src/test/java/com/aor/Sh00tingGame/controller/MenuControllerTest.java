package com.aor.Sh00tingGame.controller;
import static org.mockito.Mockito.*;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.menu.MenuController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.states.ControlsState;
import com.aor.Sh00tingGame.states.GameState;
import com.aor.Sh00tingGame.states.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MenuControllerTest {
    private Game game;
    private GUI gui;
    private Menu menu;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        this.game = mock(Game.class);
        this.gui = mock(GUI.class);
        this.menu = mock(Menu.class);
        this.controller = new MenuController(menu);

        when(game.getGameState()).thenReturn(mock(GameState.class));
        when(game.getMenuState()).thenReturn(mock(MenuState.class));
    }

    @Test
    void testStep_exit() throws IOException {
        when(menu.isSelectedExit()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 0);

        verify(game).setState(null);
    }

    @Test
    void testStep_controls() throws IOException {
        ControlsState controlsState = mock(ControlsState.class);
        when(menu.isSelectedControls()).thenReturn(true);
        when(game.getState()).thenReturn(controlsState);
        controller.step(game, GUI.ACTION.SELECT, 0);

        Assertions.assertEquals(controlsState, game.getState());
    }

    @Test
    void testStep_start() throws IOException {
        when(menu.isSelectedStart()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 0);

        verify(game).setState(game.getGameState());
    }

    @Test
    void testStep_previousEntry() throws IOException {
        controller.step(game, GUI.ACTION.SHOOTUP, 0);

        verify(menu).previousEntry();
    }

    @Test
    void testStep_nextEntry() throws IOException {
        controller.step(game, GUI.ACTION.SHOOTDOWN, 0);

        verify(menu).nextEntry();
    }
}