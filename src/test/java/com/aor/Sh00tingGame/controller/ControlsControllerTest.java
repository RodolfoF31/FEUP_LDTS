package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.menu.ControlsController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.Controls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ControlsControllerTest {
    private ControlsController controller;
    private Controls controls;
    private Game game;

    @BeforeEach
    void setUp() {
        this.controls = mock(Controls.class);
        this.controller = new ControlsController(controls);
        this.game = mock(Game.class);
    }

    @Test
    void testStep_selectAction() throws IOException {
        controller.step(game, GUI.ACTION.SELECT, 0L);

        verify(game, times(1)).setState(game.getMenuState());
    }
}
