package com.aor.Sh00tingGame.controller.menu;

import com.aor.Sh00tingGame.model.menu.Controls;
import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.gui.GUI;

import java.io.IOException;

public class ControlsController extends Controller<Controls> {

    public ControlsController(Controls options) {
        super(options);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.SELECT){
            game.setState(game.getMenuState());
        }
    }
}
