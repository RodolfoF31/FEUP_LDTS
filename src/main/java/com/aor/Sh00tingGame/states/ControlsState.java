package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.controller.menu.ControlsController;
import com.aor.Sh00tingGame.model.menu.Controls;
import com.aor.Sh00tingGame.viewer.game.menu.ControlsViewer;
import com.aor.Sh00tingGame.viewer.Viewer;

public class ControlsState extends State<Controls>{

    public ControlsState(Controls model) {
        super(model);
    }

    @Override
    protected Viewer<Controls> getViewer() {
        return new ControlsViewer(getModel());
    }

    @Override
    protected Controller<Controls> getController() {
        return new ControlsController(getModel());
    }
}
