package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.controller.menu.MenuController;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.viewer.Viewer;
import com.aor.Sh00tingGame.viewer.game.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
