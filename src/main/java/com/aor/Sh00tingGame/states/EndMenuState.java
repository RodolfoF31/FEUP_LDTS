package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.controller.menu.EndMenuController;
import com.aor.Sh00tingGame.model.menu.EndMenu;
import com.aor.Sh00tingGame.viewer.Viewer;
import com.aor.Sh00tingGame.viewer.game.menu.EndMenuViewer;

public class EndMenuState extends State<EndMenu> {
    public EndMenuState(EndMenu model) {
        super(model);
    }

    @Override
    protected Viewer<EndMenu> getViewer() {
        return new EndMenuViewer(getModel());
    }

    @Override
    protected Controller<EndMenu> getController() {
        return new EndMenuController(getModel());
    }
}
