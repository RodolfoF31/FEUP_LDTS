package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.controller.menu.NextMenuController;
import com.aor.Sh00tingGame.model.menu.NextMenu;
import com.aor.Sh00tingGame.viewer.Viewer;
import com.aor.Sh00tingGame.viewer.game.menu.NextMenuViewer;

public class NextMenuState extends State<NextMenu> {

    public NextMenuState(NextMenu model) {
        super(model);
    }
    @Override
    protected Viewer<NextMenu> getViewer() {
        return new NextMenuViewer(getModel());
    }

    @Override
    protected Controller<NextMenu> getController() {
        return new NextMenuController(getModel());
    }
}
