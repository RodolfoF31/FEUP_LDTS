package com.aor.Sh00tingGame.controller.menu;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.model.menu.Controls;
import com.aor.Sh00tingGame.states.ControlsState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SHOOTUP:
                getModel().previousEntry();
                break;
            case SHOOTDOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedControls())game.setState(new ControlsState(new Controls()));
                if (getModel().isSelectedStart()) {
                    game.setState(game.getGameState());
                }

        }
    }
}
